package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectDAO {

	List<Project> getAllProjects();

	boolean createProject(Project project);
	
}
