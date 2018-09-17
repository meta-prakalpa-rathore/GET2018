package dao;

public class Queries {

	public static final String ADD_USER_QUERY = "INSERT INTO users(first_name, last_name, dob, email, password, contact_number, organization) "
            									+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	public static final String CHECK_EMAIL_QUERY = "SELECT COUNT(*) AS count "
												+ "FROM users "
												+ "WHERE email = ?";
	
	public static final String VALIDATE_LOGIN_QUERY = "SELECT password "
												+ "FROM users "
												+ "WHERE email = ?";
	
	public static final String GET_ID_QUERY = "SELECT id "
                                                + "FROM users "
                                                + "WHERE email = ?";
	
	public static final String GET_USER_DETAILS = "SELECT first_name, last_name, email, contact_number, organization, dob, "
	        + "DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(dob, '%Y') - (DATE_FORMAT(NOW(), '00-%m-%d') < DATE_FORMAT(dob, '00-%m-%d')) AS age "
	        + "FROM users "
	        + "WHERE id = ?";
	
	public static final String UPDATE_USER_QUERY = "UPDATE users "
	        + "SET first_name = ?, last_name = ?, email = ?, contact_number = ?, organization = ?, dob = ? "
	        + "WHERE id = ?";
	
	public static final String GET_FRIENDS_QUERY = "SELECT first_name, last_name, email, contact_number, organization, dob, "
            + "DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(dob, '%Y') - (DATE_FORMAT(NOW(), '00-%m-%d') < DATE_FORMAT(dob, '00-%m-%d')) AS age "
            + "FROM users "
            + "WHERE id <> ? AND organization = ?";
	
	public static final String SET_PROFILE_IMAGE_QUERY = "UPDATE users "
                                        	        + "SET profile_photo = ? "
                                        	        + "WHERE email = ?";
	
	public static final String GET_PROFILE_IMAGE = "SELECT profile_photo "
	        + "FROM users "
	        + "WHERE email = ?";
}
