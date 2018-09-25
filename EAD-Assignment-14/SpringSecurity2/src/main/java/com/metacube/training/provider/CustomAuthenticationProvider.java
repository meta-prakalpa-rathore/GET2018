package com.metacube.training.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.metacube.training.model.User;
import com.metacube.training.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	
    private static List<User> users;

    public CustomAuthenticationProvider() {
        users = userService.getAllUsers();
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        System.out.println("credentials class: " + credentials.getClass());
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();

        User userOptional =  null ;
        
        for (User user : users) {
			if(user.match(name, password)) {
				userOptional = user;
			}
		}

        if (userOptional == null) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.getRole()));
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}