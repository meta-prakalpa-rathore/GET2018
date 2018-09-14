package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectDAO {

	List<Project> getAllProjects();

	void createProject(Project project);
	
	Project getProjectById(int id);
	
}
