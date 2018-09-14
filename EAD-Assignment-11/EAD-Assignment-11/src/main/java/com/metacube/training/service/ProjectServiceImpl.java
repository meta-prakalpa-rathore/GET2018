package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static ProjectServiceImpl ProjectServiceObject = new ProjectServiceImpl();
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public static ProjectServiceImpl getInstance() {
		
		return ProjectServiceObject;
	}
	
	
	public void addProject(Project project) {
				
		projectDAO.createProject(project);
	}


	public List<Project> getAllProjects() {
		
		return projectDAO.getAllProjects();
	}

}
