package com.metacube.training.service;

import java.util.List;

import com.metacube.training.enums.SearchCriteria;
import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

public interface EmployeeService {

	public boolean addEmployee(PreSignupTO preSignupTO);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchEmployee(SearchCriteria criteria, String keyword);
	
	public Employee getEmployeeByCode(String employeeCode);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean isValidLogin(String username, String password);
	
	public Employee getEmployeeByEmail(String email);
	
	public void addSkills(String[] skills, String employeeCode);
	
	public boolean isEmailExist(String email);

}
