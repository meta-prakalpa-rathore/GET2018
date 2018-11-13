package com.metacube.training.dao;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
    

    @Autowired
    public ProjectDAOImpl(DataSource dataSource) {
        
    	jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
	private static final String SQL_GET_ALL = "SELECT * FROM project";
	
	private static final String SQL_INSERT_PROJECT = "INSERT INTO project(description, start_date, end_date, project_logo) "
									+ "VALUES(?,?,?,?)";
	
	

	public List<Project> getAllProjects() {
		
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}


	public boolean createProject(Project project) {

	    return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getDescription(), new Date(project.getStartDate().getTime()),
				new Date(project.getEndDate().getTime()), project.getProjectLogo()) > 0;
	}

}
