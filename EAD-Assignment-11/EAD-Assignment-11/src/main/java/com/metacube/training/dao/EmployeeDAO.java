package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;

/**
 * @author Prakalpa-Rathore
 *
 */
public interface EmployeeDAO {

	public void preSignup(Employee employee, JobDetails jobDetails);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchByName(String name);
	
	public List<Employee> searchByProject(int projectId);
	
	public List<Employee> searchBySkills(String skill);
	
	public List<Employee> searchByExperience(double experience);
	
	public Employee getEmployeeByCode(String employeeCode);
	
	public boolean updateEmployee(Employee employee);
	
	public Employee getEmployeeByEmail(String email);
	
	public void addSkill(EmployeeSkills skill);
}
