package com.metacube.training.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.enums.SearchCriteria;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.AdminService;
import com.metacube.training.service.AdminServiceImpl;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeServiceImpl;
import com.metacube.training.service.JobService;
import com.metacube.training.service.JobServiceImpl;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.ProjectServiceImpl;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SkillService skillService;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private JobService jobService;
    
    @Autowired
    private EmployeeService employeeService;
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		
		if(adminService.isValidLogin(username, password))
			view = "redirect:/admin/dashboard";
		else
			view = "admin/login";
		
		return new ModelAndView(view);
	}
	
	
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(){
           return "admin/dashboard";
    }
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String addProject(){
	    
		return "admin/project";
	}
	
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ModelAndView addProject(@RequestParam("description") String description, @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate, @RequestParam MultipartFile logo) throws IOException, ParseException{
		
		Date startDt = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date endDt = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		
		Project project = new Project();
		project.setDescription(description);
		project.setStartDate(startDt);
		project.setEndDate(endDt);
		project.setProjectLogo(logo.getBytes());
		
		projectService.addProject(project);
		
		return new ModelAndView("redirect:/admin/project");
	}
	
	
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill(){
		
		return "admin/skills";
	}
	
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView addSkill(@RequestParam("skillName") String skillName){
		
	    Skill skill = new Skill();
	    skill.setName(skillName);
	    
	    skillService.addSkill(skill);
	    
		return new ModelAndView("redirect:/admin/skills");
	}
	
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(){
		
		return "admin/jobTitle";
	}
	
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(@RequestParam("jobTitle") String jobTitle){
		
	    JobTitle jobTitle2 = new JobTitle();
	    jobTitle2.setJobTitle(jobTitle);
	    
	    jobService.addJobTitle(jobTitle2);
	    
		return new ModelAndView("redirect:/admin/jobTitle");
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(){
		
        List<Employee> listOfEmployees = employeeService.getAllEmployees();
        
        List<Project> listOfProjects = projectService.getAllProjects();
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("listOfEmployees", listOfEmployees);
        model.put("listOfProjects", listOfProjects);
        
		return new ModelAndView("admin/addEmployee", model);
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("fname") String firstName, @RequestParam("mname") String middleName, 
			@RequestParam("lname") String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam("gender") char gender, @RequestParam("doj") String doj, @RequestParam("reportingMgr") String reportingMgr, 
			@RequestParam("teamLead") String teamLead, @RequestParam("projectId") Integer projectId) throws ParseException{
		
		if("n/a".equals(reportingMgr))
			reportingMgr = null;
		
		if("n/a".equals(teamLead))
			teamLead = null;
		
		if(projectId == 0)
			projectId = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = format.parse(dob);
		Date dateOfJoining = format.parse(doj);
		
		PreSignupTO preSignupTO = new PreSignupTO();
		preSignupTO.setFirstName(firstName);
		preSignupTO.setMiddleName(middleName);
		preSignupTO.setLastName(lastName);
		preSignupTO.setEmail(email);
		preSignupTO.setDob(dateOfBirth);
		preSignupTO.setGender(gender);
		preSignupTO.setDoj(dateOfJoining);
		preSignupTO.setReportingMgr(reportingMgr);
		preSignupTO.setTeamLead(teamLead);
		preSignupTO.setProjectId(projectId);
		
		employeeService.addEmployee(preSignupTO);
		
		return new ModelAndView("redirect:/admin/addEmployee");
	}
	
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(){
		
		return "admin/searchEmployee";
	}
	
	
	@RequestMapping(value = "/searchResults", method = RequestMethod.GET)
	public ModelAndView searchEmployee(@RequestParam("criteria") String criteria1, @RequestParam("keyword") String keyword){
		
	    SearchCriteria criteria;
	    
	    switch(criteria1)
	    {
	        case "name" : criteria = SearchCriteria.NAME;
	                      break;
	                      
	        case "project" : criteria = SearchCriteria.PROJECT;
	                         break;
	                         
	        case "skill" : criteria = SearchCriteria.SKILL;
	                       break;
	        
	        case "experience" : criteria = SearchCriteria.EXPERIENCE;
	                            break;
	                            
	        default : criteria = null;
	    }
		List<Employee> searchResult = employeeService.searchEmployee(criteria, keyword);
		
		return new ModelAndView("admin/searchResults", "result", searchResult);
	}
	
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam String employeeCode){
		
		
		return new ModelAndView("admin/editEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam String employeeCode, @RequestParam String firstName, @RequestParam String middleName, 
			@RequestParam String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam char gender, @RequestParam String primaryContact, @RequestParam String secondaryContact,
			@RequestParam String skypeId, @RequestParam boolean enabled, @RequestParam String password) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = format.parse(dob);
		
		Employee employee = new Employee();
		employee.setEmployeeCode(employeeCode);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setDob(dateOfBirth);
		employee.setGender(gender);
		employee.setPrimaryContact(primaryContact);
		employee.setSecondaryContact(secondaryContact);
		employee.setSkypeId(skypeId);
		employee.setEnabled(enabled);
		employee.setPassword(password);
		
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("admin/dashboard");
	}

}
