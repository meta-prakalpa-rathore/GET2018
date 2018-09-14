package com.metacube.training.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobTitle;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO{


	@Autowired
    private SessionFactory sessionFactory;
    
    public void createJobTitle(JobTitle jobTitle) {
        
        sessionFactory.getCurrentSession().save(jobTitle);
    }

    
}
