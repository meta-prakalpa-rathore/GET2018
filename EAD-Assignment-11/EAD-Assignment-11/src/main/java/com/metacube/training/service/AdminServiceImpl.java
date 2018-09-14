package com.metacube.training.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	private static AdminServiceImpl adminServiceObject = new AdminServiceImpl();
	
	public static AdminServiceImpl getInstance() {
		
		return adminServiceObject;
	}
	
	
	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if("admin".equals(username) && "admin".equals(password))
			valid = true;
		
		return valid;
	}

}
