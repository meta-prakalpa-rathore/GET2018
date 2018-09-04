package dao;

/**
 * class that contains all the queries used by dao
 * @author Prakalpa-Rathore
 *
 */
public class Queries {

    public static final String CREATE_CATEGORY = "INSERT INTO category(category_name) "
                                                + "VALUES(?)";
    
    public static final String GET_CATEGORIES = "SELECT * "
                                                + "FROM category";
    
    public static final String GET_CATEGORY_NAME = "SELECT category_name "
                                                + "FROM category "
                                                + "WHERE id = ?";
    
    public static final String CREATE_ADVERTISEMENT = "INSERT INTO advertisement(title, description, category_id) "
                                                + "VALUES(?, ?, ?)";
    
    public static final String GET_ADVERTISEMENTS = "SELECT * "
                                                + "FROM advertisement";
    
    public static final String GET_ADVERTISEMENTS_BY_CATEGORY = "SELECT * "
									            + "FROM advertisement "
									            + "WHERE category_id = ?";
    
    public static final String GET_ADVERTISEMENT_TITLE = "SELECT title "
									            + "FROM advertisement "
									            + "WHERE id = ?";
    
    public static final String UPDATE_ADVERTISEMENT_NAME = "UPDATE advertisement "
    											+ "SET title = ? "
    											+ "WHERE id = ?";
    
    public static final String UPDATE_CATEGORY_NAME = "UPDATE category "
												+ "SET category_name = ? "
												+ "WHERE id = ?";
    
    public static final String DELETE_ADVERTISEMENT = "DELETE FROM advertisement "
    											+ "WHERE id = ?";
}
