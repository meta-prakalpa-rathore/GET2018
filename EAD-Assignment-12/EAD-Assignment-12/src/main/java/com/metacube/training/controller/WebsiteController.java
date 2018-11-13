package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebsiteController {

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }
    
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(){
		
		return "redirect:/";
	}
}
