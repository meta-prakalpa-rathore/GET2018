package com.java;

/**
 * Class to store the Employee Details
 * @author Prakalpa-Rathore
 *
 */
public class Employee {

    private String firstName, lastName, email;
    private int age;
    
    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param age
     */
    public Employee(String firstName, String lastName, String email, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    
    
    /**
     * getter method for firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    
    
    /**
     * setter method for firstName
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    /**
     * getter method for lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    
    /**
     * setter method for lastName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    /**
     * getter method for email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    
    /**
     * setter method for email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /**
     * getter method for age
     * @return age
     */
    public int getAge() {
        return age;
    }
    
    
    /**
     * setter method for age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }   
}
