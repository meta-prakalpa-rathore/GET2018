package com.metacube.training.mappers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet resultSet, int i) throws SQLException {

		Project project = new Project();
		project.setProjectId(resultSet.getInt("project_id"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));
		Blob logo = resultSet.getBlob("project_logo");
		if(logo != null)
		    project.setProjectLogo(logo.getBinaryStream());
		else
		    project.setProjectLogo(null);
		return project;
	}
}
