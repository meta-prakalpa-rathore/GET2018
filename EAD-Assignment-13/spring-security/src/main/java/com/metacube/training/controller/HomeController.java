package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome() {
		return "login";
	}
	
	@RequestMapping(value="/home**", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
	
	@RequestMapping(value="/failure", method = RequestMethod.GET)
    public String failure() {
        return "failure";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }
}
