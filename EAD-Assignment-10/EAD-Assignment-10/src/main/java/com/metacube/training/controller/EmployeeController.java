package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.enums.SearchCriteria;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.service.AdminService;
import com.metacube.training.service.AdminServiceImpl;
import com.metacube.training.service.EmailService;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeServiceImpl;
import com.metacube.training.service.SkillService;
import com.metacube.training.service.SkillServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private SkillService skillService;
    
    @Autowired
    private EmailService emailService;
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "employee/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		
		if(employeeService.isValidLogin(username, password))
			view = "redirect:/employee/dashboard";
		else
			view = "employee/login";
		
		return new ModelAndView(view, "email", username);
	}
	

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(){
           
	    return "employee/dashboard";
    }
	
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String resetPassword() {
        
        return "employee/resetPassword";
    }
	
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(@RequestParam("recoveryEmail") String email) {
        
	    if(employeeService.isEmailExist(email))
	    {
	        emailService.sendRecoveryEmail(email, "Reset Password", 
	                "Your password is:" + employeeService.getEmployeeByEmail(email).getPassword());
	        
	        return "employee/sentEmail";
	    }
	    else
	        return "employee/resetPassword";
    }
	
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam String email){
		
		List<Skill> listOfSkills = skillService.getAllSkills();
		
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("listOfSkills", listOfSkills);
        model.put("employee", employeeService.getEmployeeByEmail(email));
		
		return new ModelAndView("employee/editProfile", model);
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("employeeCode") String employeeCode, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, 
			@RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam("gender") char gender, @RequestParam("primaryContact") String primaryContact, @RequestParam("secondaryContact") String secondaryContact,
			@RequestParam("skypeId") String skypeId, @RequestParam("skills") String[] skills,@RequestParam("oldPassword") String oldPassword,
			@RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, @RequestParam("enabled") boolean enabled) throws ParseException{
		
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
		
		if(!"".equals(password) && password.equals(confirmPassword))
			employee.setPassword(password);
		else
			employee.setPassword(oldPassword);
		
		employeeService.addSkills(skills, employeeCode);
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("redirect:/employee/dashboard", "email", email);
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(){
		
		return new ModelAndView("employee/searchEmployee");
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
		
		return new ModelAndView("employee/searchResults", "result", searchResult);
	}
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
}
