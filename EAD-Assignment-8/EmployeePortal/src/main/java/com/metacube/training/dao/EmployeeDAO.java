package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Prakalpa-Rathore
 *
 */
public interface EmployeeDAO {

	public boolean preSignup(PreSignupTO preSignupTO);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchByName(String name);
	
	public List<Employee> searchByProject(int projectId);
	
	public List<Employee> searchBySkills(String skill);
	
	public List<Employee> searchByExperience(double experience);
	
	public Employee getEmployeeByCode(String employeeCode);
	
	public boolean updateEmployee(Employee employee);
	
	public Employee getEmployeeByEmail(String email);
	
	public boolean addSkill(Skill skill, String employeeCode);
}
