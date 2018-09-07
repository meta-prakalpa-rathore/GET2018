package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.Dao;
import dao.MySqlDao;
import entity.Advertisement;
import entity.Category;
import entity.Response;

/**
 * class used to perform operations
 * @author Prakalpa-Rathore
 *
 */
@Path("/advertise")
public class Resource {

    Dao dao = new MySqlDao();
    Gson gson = new Gson();
    
    
    /**
     * method to create a new category
     * @param category
     */
    @Path("/categories/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCategory(@HeaderParam("Authorization") String authorization, Category category)
    {
        int status;
        String message;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
        }
        else if(!dao.createCategory(category))
        {
            status = 400;
            message = "This category already exists! Cannot create again";
        }
        else 
        {
            status = 200;
            message = "Category created";
        }
        
        return new Response(status, message, null);
    }
    
    
    /**
     * method to retrieve all the categories
     * @return List of categories
     */
    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(@HeaderParam("Authorization") String authorization)
    {
        int status;
        String message;
        Object data;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
            data = null;
        }
        else
        {   
            status = 200;
            message = "listing all categories";
            data = dao.getCategories();
        }
        
        return new Response(status, message, gson.toJsonTree(data));
    }
    
    
    /**
     * method to create a new advertisement
     * @param categoryId
     * @param advertisement
     */
    @Path("/categories/{id}/advertisements/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAdvertisement(@HeaderParam("Authorization") String authorization, @PathParam("id") int categoryId, Advertisement advertisement)
    {
        int status;
        String message;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
        }
        else if(advertisement.getCategoryId() != categoryId)
        {
            status = 400;
            message = "category IDs don't match";
        }
        else if(!dao.isCategoryExist(categoryId))
        {
            status = 400;
            message = "category does not exist";
        }
        else
        {
            dao.createAdvertisement(advertisement);
            status = 200;
            message = "Advertisement created";
        }
        
        return new Response(status, message, null);
    }
    
    
    /**
     * method to retrieve all advertisements
     * @return list of advertisement
     */
    @Path("/advertisements")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdvertisements(@HeaderParam("Authorization") String authorization)
    {
        int status;
        String message;
        Object data;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
            data = null;
        }
        else
        {
            status = 200;
            message = "listing all advertisements";
            data = dao.getAdvertisements();
        }
        
        return new Response(status, message, gson.toJsonTree(data));
    }
    
    
    /**
     * method to retrieve all advertisements of a particular category
     * @param categoryId
     * @return list of advertisement
     */
    @Path("/categories/{id}/advertisements")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertisementsByCategoryId(@HeaderParam("Authorization") String authorization, @PathParam("id") int categoryId)
    {        
        int status;
        String message;
        Object data;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
            data = null;
        }
        else if(!dao.isCategoryExist(categoryId))
        {
            status = 400;
            message = "category does not exist";
            data = null;
        }
        else
        {
            status = 200;
            message = "listing all advertisements with category id = " + categoryId;
            data = dao.getAdvertisementsByCategory(categoryId);
        }
        
        return new Response(status, message, gson.toJsonTree(data));
    }
    
    
    /**
     * method to update the title of an existing advertisement
     * @param categoryId
     * @param advertisementId
     * @param advertisement
     */
    @Path("/categories/{category_id}/advertisements/{advertisement_id}/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdvertisementName(@HeaderParam("Authorization") String authorization, @PathParam("category_id") int categoryId, @PathParam("advertisement_id") int advertisementId, Advertisement advertisement)
    {   
        int status;
        String message;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
        }
        else if(!dao.isCategoryExist(categoryId))
        {
            status = 400;
            message = "category does not exist";
        }
    	else if(advertisement.getCategoryId() != categoryId)
    	{
    	    status = 400;
            message = "category IDs don't match";
    	}
    	else if(advertisement.getId() != advertisementId)
    	{
    	    status = 400;
            message = "advertisement IDs don't match";
    	}
        else if(!dao.isAdvertisementExist(advertisementId))
        {
            status = 400;
            message = "advertisement does not exist";
        }
        else
        {
            dao.updateAdvertisementName(advertisement);
            status = 200;
            message = "Updated advertisement successfully";
        }
        	
        return new Response(status, message, null);
    }
    
    
    /**
     * method to update the name of an existing category
     * @param categoryId
     * @param category
     */
    @Path("/categories/{id}/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategoryname(@HeaderParam("Authorization") String authorization, @PathParam("id") int categoryId, Category category)
    {
        int status;
        String message;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
        }
        else if(!dao.isCategoryExist(categoryId))
        {
            status = 400;
            message = "category does not exist";
        }
    	else
    	{
    		dao.updateCategoryName(category);
    		status = 200;
            message = "Updated category successfully";
    	}
        
        return new Response(status, message, null);
    }
    
    
    /**
     * method to delete an existing advertisement
     * @param categoryId
     * @param advertisementId
     */
    @Path("/categories/{category_id}/advertisements/{advertisement_id}/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAdvertisement(@HeaderParam("Authorization") String authorization, @PathParam("category_id") int categoryId, @PathParam("advertisement_id") int advertisementId)
    {
        int status;
        String message;
        
        if(!"get-2018".equals(authorization))
        {
            status = 401;
            message = "Unauthorized Access";
        }
        else if(!dao.isCategoryExist(categoryId))
        {
            status = 400;
            message = "category does not exist";
        }
        else if(!dao.isAdvertisementExist(advertisementId))
        {
            status = 400;
            message = "advertisement does not exist";
        }
        else
        {
        	dao.deleteAdvertisement(advertisementId);
        	status = 200;
            message = "Deleted advertisement successfully";
        }
        
        return new Response(status, message, null);
    }
}
