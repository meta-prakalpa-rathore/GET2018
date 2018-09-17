package model;

import java.util.Date;

public class UserTOforRegister {

	private String firstName, lastName, email, password, contact, organization;
    Date dob;
    
	/**
	 * constructor
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param contact
	 * @param organization
	 * @param dob
	 */
	public UserTOforRegister(String firstName, String lastName, String email, String password, String contact,
			String organization, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.organization = organization;
		this.dob = dob;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	
	
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	
	
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	
	
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
