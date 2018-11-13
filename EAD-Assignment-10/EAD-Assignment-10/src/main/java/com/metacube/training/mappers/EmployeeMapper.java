package com.metacube.training.mappers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        
        Employee employee = new Employee();
        employee.setEmployeeCode(resultSet.getString("emp_code"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDob(new Date(resultSet.getDate("dob").getTime()));
        employee.setGender(resultSet.getString("gender").charAt(0));
        employee.setPrimaryContact(resultSet.getString("primary_contact_no"));
        employee.setSecondaryContact(resultSet.getString("secondary_contact_no"));
        employee.setEmail(resultSet.getString("email"));
        employee.setSkypeId(resultSet.getString("skype_id"));
        Blob profilePicture = resultSet.getBlob("profile_picture");
        if(profilePicture != null)
            employee.setProfilePicture(profilePicture.getBinaryStream());
        else
            employee.setProfilePicture(null);
        employee.setPassword(resultSet.getString("password"));
        employee.setEnabled(resultSet.getBoolean("enabled"));
        return employee;
    }

}
