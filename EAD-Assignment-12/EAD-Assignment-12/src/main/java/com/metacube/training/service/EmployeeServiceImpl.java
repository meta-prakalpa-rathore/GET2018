package com.metacube.training.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.enums.SearchCriteria;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.EmployeeSkillsRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl employeeServiceObject = new EmployeeServiceImpl();
	
	@Autowired
	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	private ProjectRepository<Project> projectRepository;
	
	@Autowired
	private SkillRepository<Skill> skillRepository;
	
	@Autowired
	private JobDetailsRepository<JobDetails> jobDetailsRepository;
	
	@Autowired
	private EmployeeSkillsRepository<EmployeeSkills> employeeSkillsRepository;
	
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
		employee.setPassword("123456");
		employee.setEnabled(true);
		
		JobDetails jobDetails = new JobDetails();
		String reportingMgr = preSignupTO.getReportingMgr();
		String teamLead = preSignupTO.getTeamLead();
		Integer projectId = preSignupTO.getProjectId();
		
		if(reportingMgr != null)
		    jobDetails.setReportingMgr(employeeRepository.findByEmployeeCode(reportingMgr));
		else
		    jobDetails.setReportingMgr(null);
		
		if(teamLead != null)
		    jobDetails.setTeamLead(employeeRepository.findByEmployeeCode(teamLead));
		else
		    jobDetails.setTeamLead(null);
		
		jobDetails.setDateOfJoining(preSignupTO.getDoj());
		
		if(projectId != null)
		    jobDetails.setProjectId(projectRepository.findByProjectId(projectId));
		else
		    jobDetails.setProjectId(null);
		
		jobDetails.setEmployeeCode(employee);
        
		employeeRepository.save(employee);
		jobDetailsRepository.save(jobDetails);
	}


	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	public List<Employee> searchEmployee(SearchCriteria criteria, String keyword) {
		
		List<Employee> listOfEmployees = null;
		
		switch (criteria) {
			
			case NAME : listOfEmployees = employeeRepository.searchByName(keyword);
						  break;
						  
			case PROJECT : int projectId = (int)Integer.parseInt(keyword);
			                listOfEmployees = employeeRepository.searchByProjectId(projectRepository.findByProjectId(projectId));
							 break;
							 
			case SKILL : listOfEmployees = employeeRepository.searchBySkills(keyword);
						   break;
						   
			case EXPERIENCE : listOfEmployees = employeeRepository.searchByExperience(Double.parseDouble(keyword));
								break;
		}
		
		return listOfEmployees;
	}
	
	
	public List<Employee> searchEnabledEmployee(SearchCriteria criteria, String keyword) {
        
        List<Employee> listOfEmployees = null;
        
        switch (criteria) {
            
            case NAME : listOfEmployees = employeeRepository.searchByNameEnabledTrue(keyword);
                          break;
                          
            case PROJECT : int projectId = (int)Integer.parseInt(keyword);
                            listOfEmployees = employeeRepository.searchByProjectIdEnabledTrue(projectRepository.findByProjectId(projectId));
                             break;
                             
            case SKILL : listOfEmployees = employeeRepository.searchBySkillsEnabledTrue(keyword);
                           break;
                           
            case EXPERIENCE : listOfEmployees = employeeRepository.searchByExperienceEnabledTrue(Double.parseDouble(keyword));
                                break;
        }
        
        return listOfEmployees;
    }
	

	public Employee getEmployeeByCode(String employeeCode) {
		
		return employeeRepository.findByEmployeeCode(employeeCode);
	}
	

	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}


	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if(password.equals(getEmployeeByEmail(username).getPassword()))
			valid = true;
		
		return valid;
	}
	
	public Employee getEmployeeByEmail(String email) {
		
		return employeeRepository.findByEmail(email);
	}

	
	public void addSkills(String[] skills, String employeeCode) {
				
		for(String skillName: skills)
		{
			if(!"n/a".equals(skillName))
			{
			    Skill skill = skillService.getSkillByName(skillName);
			    EmployeeSkills employeeSkill = new EmployeeSkills();
			    employeeSkill.setEmployeeCode(employeeRepository.findByEmployeeCode(employeeCode));
			    employeeSkill.setSkillCode(skillRepository.findById(skill.getId()));
				employeeSkillsRepository.save(employeeSkill);
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
