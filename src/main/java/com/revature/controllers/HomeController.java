package com.revature.controllers;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("In HomeController - returned home");
		return "home";
	}
}