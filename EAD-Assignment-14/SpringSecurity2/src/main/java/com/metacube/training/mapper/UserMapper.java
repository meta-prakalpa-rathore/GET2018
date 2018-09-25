package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.User;

public class UserMapper implements RowMapper<User>  {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setRole(resultSet.getString("role"));
		return user;
	}

}
