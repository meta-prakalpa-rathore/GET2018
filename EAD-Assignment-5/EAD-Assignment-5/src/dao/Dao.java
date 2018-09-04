package dao;

import java.util.List;

import entity.Advertisement;
import entity.Category;

/**
 * interface to perform various operations on the database
 * @author Prakalpa-Rathore
 *
 */
public interface Dao {

    /**
     * method to create a new category
     * @param category
     * @return boolean value
     */
    public boolean createCategory(Category category);
    
    
    /**
     * method to retrieve all categories from database
     * @return list of category
     */
    public List<Category> getCategories();
    
    
    /**
     * method to check if the given category exists in the database
     * @param categoryId
     * @return boolean value
     */
    public boolean isCategoryExist(int categoryId);
    
    
    /**
     * method to check if the given advertisement exists in the database
     * @param advertisementId
     * @return boolean value
     */
    public boolean isAdvertisementExist(int advertisementId);
    
    
    /**
     * method to create a new advertisement
     * @param advertisement
     */
    public void createAdvertisement(Advertisement advertisement);
    
    
    /**
     * method to retrieve all the advertisements from the database
     * @return list of advertisement
     */
    public List<Advertisement> getAdvertisements();
    
    
    /**
     * method to retrieve all the advertisements of a particular category from the database
     * @param categoryId
     * @return list of advertisement
     */
    public List<Advertisement> getAdvertisementsByCategory(int categoryId);
    
    
    /**
     * method to update the title of an existing advertisement
     * @param advertisement
     */
    public void updateAdvertisementName(Advertisement advertisement);
    
    
    /**
     * method to update the name of an existing category
     * @param category
     */
    public void updateCategoryName(Category category);
    
    
    /**
     * method to delete the given advertisement
     * @param advertisementId
     */
    public void deleteAdvertisement(int advertisementId);
}
