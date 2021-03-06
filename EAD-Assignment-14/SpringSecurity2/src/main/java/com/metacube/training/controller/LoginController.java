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
	
	@RequestMapping(value = "/401" , method = RequestMethod.GET)
	public String errorPage401() {
		return "401";
	}
	
	@RequestMapping(value = "/403" , method = RequestMethod.GET)
    public String errorPage403() {
        return "403";
    }

}