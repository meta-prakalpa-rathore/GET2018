package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.UserDAO;
import com.metacube.training.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
}
