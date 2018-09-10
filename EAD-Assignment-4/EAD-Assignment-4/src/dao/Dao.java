package dao;

import java.io.InputStream;
import java.util.List;

import model.UserTOforProfile;
import model.Users;

public interface Dao {

	public boolean addUser(Users user);
	
	public boolean validateEmail(String email);
	
	public boolean validateLogin(String email, String password);
	
	public int getID(String email);
	
	public UserTOforProfile fetchUserDetails(int id);
	
	public boolean updateUser(UserTOforProfile user, int id);
	
	public List<UserTOforProfile> getFriends(int id, String organization);
	
	public boolean setProfileImage(InputStream inputStream, String email);
	
	public byte[] getProfileImage(String email);
}
