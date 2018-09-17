package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobTitleRepository<JobTitle> jobTitleRepository;
      
    public void addJobTitle(JobTitle jobTitle) {
                
        jobTitleRepository.save(jobTitle);
    }

}
