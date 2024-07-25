package com.itrc.itrclinks.core.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itrc.itrclinks.core.service.UserManager;

@Controller
public class HomeController {
	
	@Autowired
	private UserManager userManager;
	
	private static String HOME_PAGE = "dashboard/index";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("users", userManager.getAllUsers());
		model.addAttribute("message", LocalDate.now());
		return HOME_PAGE;
	}
}
