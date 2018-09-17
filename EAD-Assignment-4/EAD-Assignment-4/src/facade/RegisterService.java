package facade;

import dao.Dao;
import dao.MysqlUserDao;
import model.UserTOforRegister;
import model.Users;

public class RegisterService {

	private static Dao dao = new MysqlUserDao();
	
	public static boolean addUser(UserTOforRegister userTO) {
		
		boolean inserted = false;
		
		if(isValid(userTO))
			inserted = dao.addUser(new Users(userTO.getFirstName(), userTO.getLastName(), userTO.getDob(), userTO.getEmail(), userTO.getPassword(), userTO.getContact(), userTO.getOrganization()));
		
		return inserted;
	}
	
	private static boolean isValid(UserTOforRegister userTO)
	{
		boolean valid = true;
		
		if(!dao.validateEmail(userTO.getEmail()))
			valid = false;
		else if(userTO.getFirstName().length() < 2 || !userTO.getFirstName().matches( "[a-zA-Z\\s]*" ))
			valid = false;
		else if(userTO.getLastName().length() < 2 || !userTO.getLastName().matches( "[a-zA-Z]*" ))
			valid = false;
		else if(!userTO.getEmail().matches("(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))"))
			valid = false;
		else if(!userTO.getPassword().matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{8,16}"))
			valid = false;
		else if(userTO.getContact().length() < 8 || !userTO.getContact().matches("[0-9]*"))
			valid = false;
		
		return valid;
	}
}
