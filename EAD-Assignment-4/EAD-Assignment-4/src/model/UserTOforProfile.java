package model;

import java.util.Date;

public class UserTOforProfile {

    private String firstName, lastName, email, contact, organization;
    int age;
    Date dob;
    
    
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param contact
     * @param organization
     * @param age
     */
    public UserTOforProfile(String firstName, String lastName, String email,
            String contact, String organization, int age, Date dob) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.organization = organization;
        this.age = age;
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
     * @return the age
     */
    public int getAge() {
        return age;
    }


    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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
