package com.metacube.training.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.dao.SkillDAO;
import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.enums.SearchCriteria;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Skill;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl employeeServiceObject = new EmployeeServiceImpl();
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Autowired
	private ProjectDAO projectDao;
	
	@Autowired
	private SkillDAO skillDao;
	
	@Autowired
    private SkillService skillService;
	
	public static EmployeeServiceImpl getInstance() {
		
		return employeeServiceObject;
	}
	
	
	public void addEmployee(PreSignupTO preSignupTO) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(preSignupTO.getDoj());
		int year = calendar.get(Calendar.YEAR);
		
		preSignupTO.setEmployeeCode(generateEmployeeCode(year));
		
		Employee employee = new Employee();
		employee.setEmployeeCode(preSignupTO.getEmployeeCode());
		employee.setFirstName(preSignupTO.getFirstName());
		employee.setMiddleName(preSignupTO.getMiddleName());
		employee.setLastName(preSignupTO.getLastName());
		employee.setEmail(preSignupTO.getEmail());
		employee.setDob(preSignupTO.getDob());
		employee.setGender(preSignupTO.getGender());
		
		JobDetails jobDetails = new JobDetails();
		String reportingMgr = preSignupTO.getReportingMgr();
		String teamLead = preSignupTO.getTeamLead();
		Integer projectId = preSignupTO.getProjectId();
		
		if(reportingMgr != null)
		    jobDetails.setReportingMgr(employeeDao.getEmployeeByCode(reportingMgr));
		else
		    jobDetails.setReportingMgr(null);
		
		if(teamLead != null)
		    jobDetails.setTeamLead(employeeDao.getEmployeeByCode(teamLead));
		else
		    jobDetails.setTeamLead(null);
		
		jobDetails.setDateOfJoining(preSignupTO.getDoj());
		
		if(projectId != null)
		    jobDetails.setProjectId(projectDao.getProjectById(projectId));
		else
		    jobDetails.setProjectId(null);
		
		jobDetails.setEmployeeCode(employee);
        
		employeeDao.preSignup(employee, jobDetails);
	}


	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}


	public List<Employee> searchEmployee(SearchCriteria criteria, String keyword) {
		
		List<Employee> listOfEmployees = null;
		
		switch (criteria) {
			
			case NAME : listOfEmployees = employeeDao.searchByName(keyword);
						  break;
						  
			case PROJECT : listOfEmployees = employeeDao.searchByProject((int)Integer.parseInt(keyword));
							 break;
							 
			case SKILL : listOfEmployees = employeeDao.searchBySkills(keyword);
						   break;
						   
			case EXPERIENCE : listOfEmployees = employeeDao.searchByExperience(Double.parseDouble(keyword));
								break;
		}
		
		return listOfEmployees;
	}
	

	public Employee getEmployeeByCode(String employeeCode) {
		
		return employeeDao.getEmployeeByCode(employeeCode);
	}
	

	public boolean updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}


	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if(password.equals(getEmployeeByEmail(username).getPassword()))
			valid = true;
		
		return valid;
	}
	
	public Employee getEmployeeByEmail(String email) {
		
		return employeeDao.getEmployeeByEmail(email);
	}

	
	public void addSkills(String[] skills, String employeeCode) {
				
		for(String skillName: skills)
		{
			if(!"n/a".equals(skillName))
			{
			    Skill skill = skillService.getSkillByName(skillName);
			    EmployeeSkills employeeSkill = new EmployeeSkills();
			    employeeSkill.setEmployeeCode(employeeDao.getEmployeeByCode(employeeCode));
			    employeeSkill.setSkillCode(skillDao.getSkillById(skill.getId()));
				employeeDao.addSkill(employeeSkill);
			}
				
		}
		
	}
	
	private String generateEmployeeCode(int year) {
		
	    String employeeCode;
		List<Employee> listOfEmployee = getAllEmployees();
		int size = listOfEmployee.size();
		if(size > 0)
		{
		    int[] codes = new int[size];
	        
	        for(int i = 0; i < size; i++)
	            codes[i] = Integer.parseInt(listOfEmployee.get(i).getEmployeeCode().split("/")[1]);
	            
	        Arrays.sort(codes);
	        employeeCode = "E" + year + "/" + (codes[size - 1] + 1);
		}
		else
		    employeeCode = "E" + year + "/" + 1;
		
		return employeeCode;
	}

}
