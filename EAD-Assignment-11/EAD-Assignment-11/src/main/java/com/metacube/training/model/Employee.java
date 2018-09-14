package com.metacube.training.model;

import java.io.InputStream;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Prakalpa-Rathore
 *
 */
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "emp_code")
	private String employeeCode;
    
    @Column(name = "first_name")
	private String firstName;
    
    @Column(name = "middle_name")
	private String middleName;
    
    @Column(name = "last_name")
	private String lastName;
    
    @Column(name = "primary_contact_no")
	private String primaryContact;
    
    @Column(name = "secondary_contact_no")
	private String secondaryContact;
    
    @Column(name = "email")
	private String email;
    
    @Column(name = "skype_id")
	private String skypeId;
    
    @Column(name = "password")
	private String password;
    
    @Column(name = "dob")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date dob;
    
    @Column(name = "gender")
	private char gender;
    
    @Lob()
    @Column(name = "profile_picture", columnDefinition="MEDIUMBLOB")
	private byte[] profilePicture;
    
    @Column(name = "enabled")
	private boolean enabled;
	
	
	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	 * @return the primaryContact
	 */
	public String getPrimaryContact() {
		return primaryContact;
	}
	
	
	/**
	 * @param primaryContact the primaryContact to set
	 */
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	
	
	/**
	 * @return the secondaryContact
	 */
	public String getSecondaryContact() {
		return secondaryContact;
	}
	
	
	/**
	 * @param secondaryContact the secondaryContact to set
	 */
	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
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
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}
	
	
	/**
	 * @param skypeId the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
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
	
	
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	/**
	 * @return the profilePicture
	 */
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	
	
	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


    
    @Override
    public String toString() {
        return "Employee [employeeCode=" + employeeCode + ", firstName="
                + firstName + ", middleName=" + middleName + ", lastName="
                + lastName + ", primaryContact=" + primaryContact
                + ", secondaryContact=" + secondaryContact + ", email=" + email
                + ", skypeId=" + skypeId + ", password=" + password + ", dob="
                + dob + ", gender=" + gender + ", profilePicture="
                + profilePicture + ", enabled=" + enabled + "]";
    }
}
