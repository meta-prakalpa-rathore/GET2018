package dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.UserTOforProfile;
import model.Users;

public class MysqlUserDao implements Dao {

    public boolean addUser(Users user)
    {
        boolean inserted = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.ADD_USER_QUERY);
        ){
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setDate(3, new java.sql.Date(user.getDob().getTime()));
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getContact());
            stmt.setString(7, user.getOrganization());

            int result = stmt.executeUpdate();
            if(result > 0)
                inserted = true;     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return inserted;
    }
    
    public boolean validateEmail(String email)
    {
    	boolean valid = false;
    	
    	try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.CHECK_EMAIL_QUERY);
        ){
            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery();
            result.next();
            if(result.getInt("count") == 0)
            	valid = true;
            	
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
    	
    	return valid;
    }
    
    public boolean validateLogin(String email, String password)
    {
    	boolean valid = false;
    	
    	try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.VALIDATE_LOGIN_QUERY);
        ){
            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery();
            result.next();
            if(result.getString("password").equals(password))
            	valid = true;
            	
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
    	
    	return valid;
    }

    
    public int getID(String email)
    {
        int id = -1;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_ID_QUERY);
        ){
            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery();
            result.next();
            id = result.getInt("id");
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return id;
    }
    
    public UserTOforProfile fetchUserDetails(int id)
    {
        UserTOforProfile user = null;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_USER_DETAILS);
        ){
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            result.next();
            user = new UserTOforProfile(result.getString("first_name"), result.getString("last_name"), result.getString("email"), result.getString("contact_number"), result.getString("organization"), Integer.parseInt(result.getString("age")), new Date(result.getDate("dob").getTime()));
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return user;
    }

    
    public boolean updateUser(UserTOforProfile user, int id)
    {
        boolean updated = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.UPDATE_USER_QUERY);
        ){
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getContact());
            stmt.setString(5, user.getOrganization());
            stmt.setDate(6, new java.sql.Date(user.getDob().getTime()));
            stmt.setInt(7, id);
            
            if(stmt.executeUpdate() > 0)
                updated = true;
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return updated;
    }

    @Override
    public List<UserTOforProfile> getFriends(int id, String organization) 
    {
        List<UserTOforProfile> listOfFriends = new ArrayList<UserTOforProfile>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_FRIENDS_QUERY);
        ){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, organization);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String contact = result.getString("contact_number");
                Date dob = new Date(result.getDate("dob").getTime());
                int age = result.getInt("age");
                
                listOfFriends.add(new UserTOforProfile(firstName, lastName, email, contact, organization, age, dob));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return listOfFriends;
    }

    
    public boolean setProfileImage(InputStream inputStream, String email) {
        
        boolean inserted = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.SET_PROFILE_IMAGE_QUERY);
        ){
            stmt.setBlob(1, inputStream);
            stmt.setString(2, email);
            
            if(stmt.executeUpdate() > 0)
                inserted = true;
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return inserted;
    }

    @Override
    public byte[] getProfileImage(String email) {
        
        byte[] blobAsBytes = null;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_PROFILE_IMAGE);
        ){
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            result.next();
            Blob imageBlob = result.getBlob("profile_photo");
            if(imageBlob != null)              
                blobAsBytes = imageBlob.getBytes(1, (int) imageBlob.length());
            else
                blobAsBytes = null;
         
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return blobAsBytes;
    }
    
    
}
