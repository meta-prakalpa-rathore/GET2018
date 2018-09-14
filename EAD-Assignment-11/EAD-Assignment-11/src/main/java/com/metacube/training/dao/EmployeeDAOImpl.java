package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;

/**
 * @author Prakalpa-Rathore
 *
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
    private SessionFactory sessionFactory;	
	
	@Autowired
	private ProjectDAO projectDao;
	
	public void preSignup(Employee employee, JobDetails jobDetails) {
		
	    sessionFactory.getCurrentSession().save(employee);
	    System.out.println("employee added"+jobDetails);
	    sessionFactory.getCurrentSession().save(jobDetails);
	}


	public List<Employee> getAllEmployees() {
		
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
        return query.getResultList();
	}


	public List<Employee> searchByName(String name) {
		
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee "
	            + "where concat(firstName, ' ', middleName, ' ', lastName) like concat('%', :name, '%')");
        query.setParameter("name", name);
        return query.getResultList();
	}


	public List<Employee> searchByProject(int projectId) {
	    
	    List<Employee> listOfEmployee = new ArrayList<Employee>();
	    Criteria c = sessionFactory.getCurrentSession().createCriteria(JobDetails.class, "jobDetail");
	    c.createAlias("jobDetail.employeeCode", "employee");
	    c.add(Restrictions.eq("jobDetail.projectId", projectDao.getProjectById(projectId)));
	    c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	    for(Object jobDetail: c.list())
	    {
	        JobDetails j = (JobDetails)jobDetail;
	        listOfEmployee.add(j.getEmployeeCode());
	    }
	    return listOfEmployee;
	    
	}


	public List<Employee> searchBySkills(String skill) {

	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee e join EmployeeSkill es join Skill s "
                + "where s.skill_name LIKE concat('%', :skill, '%')");
        query.setParameter("skill", skill);
        return query.getResultList();
	}


	public List<Employee> searchByExperience(double experience) {

	    List<Employee> listOfEmployee = new ArrayList<Employee>();
        Criteria c = sessionFactory.getCurrentSession().createCriteria(JobDetails.class, "jobDetail");
        c.createAlias("jobDetail.employeeCode", "employee");
        c.add(Restrictions.eq("jobDetail.totalExperience", experience));
        c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        for(Object jobDetail: c.list())
        {
            JobDetails j = (JobDetails)jobDetail;
            listOfEmployee.add(j.getEmployeeCode());
        }
        return listOfEmployee;
//	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee e join JobDetails j "
//                + "where j.totalExperience = :experience");
//        query.setParameter("experience", experience);
//        return query.getResultList();
	}


	public Employee getEmployeeByCode(String employeeCode) {

	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where employeeCode = :empCode");
        query.setParameter("empCode", employeeCode);
        return query.getSingleResult();
	}


	public boolean updateEmployee(Employee employee) {
		
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("UPDATE employee "
            + "SET firstName = :firstName, middleName = :middleName, lastName = :lastName, email = :email, dob = :dob, gender = :gender, "
            + "primaryContact = :primaryContact, secondaryContact = :secondaryContact, skypeId = :skypeId, enabled = :enabled, password = :password "
            + "WHERE employeeCode = :employeeCode");
	    
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("middleName", employee.getMiddleName());
        query.setParameter("lastName", employee.getLastName());
        query.setParameter("email", employee.getEmail());
        query.setParameter("dob", employee.getDob());
        query.setParameter("gender", employee.getGender());
        query.setParameter("primaryContact", employee.getPrimaryContact());
        query.setParameter("secondaryContact", employee.getSecondaryContact());
        query.setParameter("skypeId", employee.getSkypeId());
        query.setParameter("enabled", employee.isEnabled());
        query.setParameter("password", employee.getPassword());
        query.setParameter("employeeCode", employee.getEmployeeCode());
		
		return  query.executeUpdate() > 0;
	}


	public Employee getEmployeeByEmail(String email) {
		
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where email = :email");
        query.setParameter("email", email);
        return query.getSingleResult();
	}


	public void addSkill(EmployeeSkills skill) {
				
	    sessionFactory.getCurrentSession().save(skill);
	}

}
