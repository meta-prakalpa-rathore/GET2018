package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Project> getAllProjects() {
		
	    TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project");
        return query.getResultList();
	}


	public void createProject(Project project) {

	    sessionFactory.getCurrentSession().save(project);
	}


    @Override
    public Project getProjectById(int id) {
        
        TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project where projectId = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
