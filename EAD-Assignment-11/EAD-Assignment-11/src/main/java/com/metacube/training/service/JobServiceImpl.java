package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.JobTitle;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDao;
    
    private static JobServiceImpl jobServiceObject = new JobServiceImpl();
    
    public static JobServiceImpl getInstance() {
        
        return jobServiceObject;
    }
    
    public void addJobTitle(JobTitle jobTitle) {
                
        jobDao.createJobTitle(jobTitle);
    }

}
