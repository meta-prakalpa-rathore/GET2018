package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String test() {
//		return "login";
//	}
	
	@RequestMapping(value="/home**", method = RequestMethod.GET)
    public String login() {
        return "home";
    }
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String login1() {
        return "login";
    }
	
	@RequestMapping(value="/failure", method = RequestMethod.GET)
    public String login2() {
        return "failure";
    }
}
