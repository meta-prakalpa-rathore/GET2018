package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage() {
        return "login";
    }
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/error" , method = RequestMethod.GET)
	public String errorPage(){
		return "error";
	}

}