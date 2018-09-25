package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.UserMapper;
import com.metacube.training.model.User;

@Repository
public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	private String GET_ALL_USERS = "select u.username, u.password, r.role from "
            + "users u left join role r on r.username = u.username where r.role is not null";
	
	@Autowired
	public UserDAO(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<User> getAllUsers() {
		return jdbcTemplate.query(GET_ALL_USERS, new UserMapper());
	}
}
