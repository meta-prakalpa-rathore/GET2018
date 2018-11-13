package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectService {

	public void addProject(Project project);
	
	public List<Project> getAllProjects();
}
