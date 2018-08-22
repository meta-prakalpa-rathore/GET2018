package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * class to perform queries on the database
 * @author Prakalpa-Rathore
 *
 */
public class DataAccessObject 
{
    /**
     * method to fetch all order line items (Order Id, Product Id, Order Date, Total) of the given user which are in shipped state.
     * Order Line Items are sorted by order date column in chronological order.
     * @param userId
     * @return List of OrderLineItem
     */
    public static List<OrderLineItem> fetchOrderLineItems(int userId)
    {
        List<OrderLineItem> listOfOrderLineItems = new ArrayList<OrderLineItem>();
        String query = "SELECT oli.order_id, oli.product_id, o.placed_date, p.price * oli.quantity AS total "
                + "FROM product p INNER JOIN order_line_item oli ON p.product_id = oli.product_id "
                + "INNER JOIN orders o ON o.order_id = oli.order_id "
                + "WHERE o.user_id = ? AND oli.status = 'shipped' "
                + "ORDER BY o.placed_date DESC";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, userId);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int orderId = result.getInt("order_id");
                int productId = result.getInt("product_id");
                String orderDate = result.getString("placed_date");
                float total = result.getFloat("total");
                
                listOfOrderLineItems.add(new OrderLineItem(orderId, productId, orderDate, total));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return listOfOrderLineItems;
    }
    
    
    /**
     * method to insert images of a product using batch insert technique.
     * @param images
     * @param productId
     * @return boolean value
     */
    public static boolean insertImages(List<Image> images, int productId)
    {
        boolean inserted = false;
        String query = "INSERT INTO image(product_id, alternate_text, url) VALUES(?, ?, ?)";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
        ){
            try 
            {
                connection.setAutoCommit(false);
                
                for (int i = 0; i < images.size(); i++)
                {
                    stmt.setInt(1, productId);
                    stmt.setString(2, images.get(i).getAlternateText());
                    stmt.setString(3, images.get(i).getUrl());
                    stmt.addBatch();
                }

                int[] result = stmt.executeBatch();
                if(result.length > 0)
                    inserted = true;
                connection.commit();

            }
            catch (SQLException exception)
            {
                exception.printStackTrace();
                connection.rollback();
            }
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return inserted;
    }
    
    
    /**
     * method to set all those products as inactive which were not ordered by any Shopper in last 1 year.
     * @return number of products set as inactive
     */
    public static int markInactive()
    {
        int noOfUpdates = 0;
        String query = "UPDATE product "
                + "SET product_state = 'inactive' "
                + "WHERE product_id NOT IN "
                + "(SELECT DISTINCT product_id "
                + "FROM order_line_item INNER JOIN orders "
                + "WHERE placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 YEAR)));";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            
        ){
            try
            {
                noOfUpdates = stmt.executeUpdate();
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return noOfUpdates;
    }
    
    
    /**
     * method to select the category title of all top parent categories sorted alphabetically and the count of their child categories.
     * @return list of TopCategory(parentCategoryName, noOfChildCategories)
     */
    public static List<TopCategory> countChildren()
    {
        List<TopCategory> listOfTopCategories = new ArrayList<TopCategory>();
        String query1 = "CREATE FUNCTION count_children(parent_id INTEGER) "
                + "RETURNS INTEGER NOT DETERMINISTIC "
                + "BEGIN "
                + "DECLARE count INTEGER; "
                + "SELECT count(category_id) INTO count "
                + "FROM category, "
                + "(SELECT @parent_set := parent_id) initialisation "
                + "WHERE find_in_set(parent_category_id, @parent_set) AND @parent_set := concat(@parent_set, ',', category_id); "
                + "RETURN count; "
                + "END";
        
        String query2 = "SELECT name, count_children(category_id) AS children_count "
                + "FROM category "
                + "WHERE parent_category_id IS NULL "
                + "ORDER BY name ";
        
        String query3 = "DROP FUNCTION count_children";
        
        try
        (
            Connection connection = getConnection();
           
            PreparedStatement stmt1 = connection.prepareStatement(query1);
            PreparedStatement stmt2 = connection.prepareStatement(query2);
            PreparedStatement stmt3 = connection.prepareStatement(query3);
        )
        {
            stmt1.execute(); //create the function
            ResultSet result = stmt2.executeQuery();
            
            while(result.next())
            {
                String parentCategoryName = result.getString("name");
                int noOfChildCategories = result.getInt("children_count");
                
                listOfTopCategories.add(new TopCategory(parentCategoryName, noOfChildCategories));
            }
            
            stmt3.execute();//drop the function after use
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return listOfTopCategories;
    }
    
    
    /**
     * method to create a connection with the database
     * @return connection 
     */
    private static Connection getConnection()
    {
        Connection connection = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/store_front";
            connection = DriverManager.getConnection(url, "root", "12345");
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
            System.exit(1);
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        return connection;
    }
    
}
