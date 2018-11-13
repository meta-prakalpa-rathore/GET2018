package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository<Project> projectRepository;
	
	public void addProject(Project project) {
				
		projectRepository.save(project);
	}


	public List<Project> getAllProjects() {
		
		return projectRepository.findAll();
	}

}
