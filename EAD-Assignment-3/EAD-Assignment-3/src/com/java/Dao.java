package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * class to perform queries on the database
 * @author Prakalpa-Rathore
 *
 */
public class Dao {

    
    /**
     * method to add an employee to the database
     * @param employee
     * @return boolean value
     */
    public boolean addEmployee(Employee employee)
    {
        boolean inserted = false;
        String query = "INSERT INTO employee(first_name, last_name, email, age) VALUES(?, ?, ?, ?)";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setInt(4, employee.getAge());
            
            if(stmt.executeUpdate() > 0)
                inserted = true;
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return inserted;
    }
    
    
    /**
     * method to retrieve all the employee details from the database
     * @return listofEmployees
     */
    public List<Employee> getAllEmployees()
    {
        List<Employee> listOfEmployees = new ArrayList<Employee>();
        String query = "SELECT * FROM employee";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                int age = result.getInt("age");
                
                listOfEmployees.add(new Employee(firstName, lastName, email, age));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return listOfEmployees;
    }
    
    
    /**
     * method to search the employees from the database having name like the given text
     * @param text
     * @return listOfEmployees
     */
    public List<Employee> searchEmployees(String text)
    {
        List<Employee> listOfEmployees = new ArrayList<Employee>();
        String query = "SELECT * "
                + "FROM employee "
                + "WHERE concat(first_name,' ',last_name) LIKE concat('%',?,'%')"
                + "OR concat(last_name,' ',first_name) LIKE concat('%',?,'%')";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1, text);
            preparedStatement.setString(2, text);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                int age = result.getInt("age");
                
                listOfEmployees.add(new Employee(firstName, lastName, email, age));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return listOfEmployees;
    }
    
    
    /**
     * method to update details of an existing employee
     * @param employee object
     * @param oldEmail email of the employee to be updated
     * @return boolean value
     */
    public boolean updateEmployee(Employee employee, String oldEmail)
    {
        boolean updated = false;
        String query = "UPDATE employee set first_name=?, last_name=?, email=?, age=? WHERE email=?";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setInt(4, employee.getAge());
            stmt.setString(5, oldEmail);
            
            if(stmt.executeUpdate() > 0)
                updated = true;
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return updated;
    }
    
    
    /**
     * method to create a connection with the database
     * @return connection 
     */
    private Connection getConnection()
    {
        Connection connection = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            connection = DriverManager.getConnection(url, "root", "12345");
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
            System.exit(1);
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        return connection;
    }
}
