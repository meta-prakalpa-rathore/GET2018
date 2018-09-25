package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
//
//	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
//	public String welcomePage() {
//
//		return "login";
//
//	}
//	
//	@RequestMapping(value = { "/home" }, method = RequestMethod.POST)
//	public String homePostPage() {
//        return "user-home";
//	}
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homeGetPage() {
        return "user-home";
	}
}