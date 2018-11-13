package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Role;
import com.metacube.training.model.User;
import com.metacube.training.model.UserTO;
import com.metacube.training.repository.RoleRepository;
import com.metacube.training.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository<User> userRepository;
	
	@Autowired
	private RoleRepository<Role> roleRepository;
	
	public List<UserTO> getAllUsers() {
	    
	    List<UserTO> listOfUsersWithRoles = new ArrayList<UserTO>();
	    List<User> listOfUsers = userRepository.findAll();
	    
	    for(User user: listOfUsers)
	    {
	        Role role = roleRepository.findByUsername(user);
	        listOfUsersWithRoles.add(new UserTO(user.getUsername(), user.getPassword(), role.getRole()));
	    }
	    
		return listOfUsersWithRoles;
	}
}
