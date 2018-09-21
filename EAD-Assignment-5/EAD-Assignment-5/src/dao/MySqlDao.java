package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Advertisement;
import entity.Category;


/**
 * Implementation of Dao
 * @author Prakalpa-Rathore
 *
 */
public class MySqlDao implements Dao{

    /**
     * method to create a new category
     * @param category
     * @return boolean value
     */
    @Override
    public boolean createCategory(Category category) {
        
        boolean created = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.CREATE_CATEGORY);
        ){
            stmt.setString(1, category.getCategoryName());
            if(stmt.executeUpdate() > 0)
                created = true;
                
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return created;
    }

    
    /**
     * method to retrieve all categories from database
     * @return list of category
     */
    @Override
    public List<Category> getCategories() {
        
        List<Category> categories = new ArrayList<Category>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_CATEGORIES);
        ){
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("id");
                String categoryName = result.getString("category_name");
                categories.add(new Category(id, categoryName));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return categories;
    }

    
    /**
     * method to check if the given category exists in the database
     * @param categoryId
     * @return boolean value
     */
    @Override
    public boolean isCategoryExist(int categoryId) {
        boolean exists = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_CATEGORY_NAME);
        ){
            preparedStatement.setInt(1, categoryId);
            ResultSet result = preparedStatement.executeQuery();
            
            if(result.next())
                exists = true;
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return exists;
    }
    
    
    /**
     * method to check if the given advertisement exists in the database
     * @param advertisementId
     * @return boolean value
     */
    @Override
    public boolean isAdvertisementExist(int advertisementId)
    {
    	boolean exists = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENT_TITLE);
        ){
            preparedStatement.setInt(1, advertisementId);
            ResultSet result = preparedStatement.executeQuery();
            
            if(result.next())
                exists = true;
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return exists;
    }

    
    /**
     * method to create a new advertisement
     * @param advertisement
     */
    @Override
    public void createAdvertisement(Advertisement advertisement) {
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.CREATE_ADVERTISEMENT);
        ){
            stmt.setString(1, advertisement.getTitle());
            stmt.setString(2, advertisement.getDescription());
            stmt.setInt(3, advertisement.getCategoryId());
            stmt.executeUpdate();     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
    }

    
    /**
     * method to retrieve all the advertisements from the database
     * @return list of advertisement
     */
    @Override
    public List<Advertisement> getAdvertisements() {
        
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS);
        ){
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int categoryId = result.getInt("category_id");
                advertisements.add(new Advertisement(id, categoryId, title, description));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return advertisements;
        
    }

    
    /**
     * method to retrieve all the advertisements of a particular category from the database
     * @param categoryId
     * @return list of advertisement
     */
    @Override
    public List<Advertisement> getAdvertisementsByCategory(int categoryId) {
        
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS_BY_CATEGORY);
        ){
            preparedStatement.setInt(1, categoryId);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int categoryIdOfAdvertisement = result.getInt("category_id");
                advertisements.add(new Advertisement(id, categoryIdOfAdvertisement, title, description));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return advertisements;
    }

    
    /**
     * method to update the title of an existing advertisement
     * @param advertisement
     */
	@Override
	public void updateAdvertisementName(Advertisement advertisement) {
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.UPDATE_ADVERTISEMENT_NAME);
        ){
            stmt.setString(1, advertisement.getTitle());
            stmt.setInt(2, advertisement.getId());
            stmt.executeUpdate();     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
	}

	
	/**
     * method to update the name of an existing category
     * @param category
     */
	@Override
	public void updateCategoryName(Category category) {
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.UPDATE_CATEGORY_NAME);
        ){
            stmt.setString(1, category.getCategoryName());
            stmt.setInt(2, category.getId());
            stmt.executeUpdate();     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
	}

	
	/**
     * method to delete the given advertisement
     * @param advertisementId
     */
	@Override
	public void deleteAdvertisement(int advertisementId) {
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.DELETE_ADVERTISEMENT);
        ){
			stmt.setInt(1, advertisementId);
            stmt.executeUpdate();     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
	}

}
