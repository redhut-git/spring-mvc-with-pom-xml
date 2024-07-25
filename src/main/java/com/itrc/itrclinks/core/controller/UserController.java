package com.itrc.itrclinks.core.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itrc.itrclinks.core.domain.User;
import com.itrc.itrclinks.core.form.UserForm;
import com.itrc.itrclinks.core.service.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager userManager;
	
	private static String HOME_PAGE = "user/form";
	
	
	@RequestMapping(value = {"/new.htm", "/edit.htm"}, method = RequestMethod.GET)
	public String loadUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
		
		UserForm form = new UserForm();
		
		if(id != null) {
			User user = userManager.getUserId(id);
			
			form.setId(user.getId());
			form.setFullName(user.getFullName());
			form.setUsername(user.getUsername());
			
			model.addAttribute("user", user);
		}
		
		model.addAttribute("userForm", form);
		return HOME_PAGE;
	}
	
	
	@RequestMapping(value = "save.htm", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("userForm") UserForm form, BindingResult result, Model model, HttpSession session) {
		
		User user = new User();
		
		boolean update = (form.getId() > 0) ? true : false;
		
		if(update) {
			user = userManager.getUserId(form.getId());
		}
		
		user.setFullName(form.getFullName());
		user.setUsername(form.getUsername());
		user.setPassword(DigestUtils.md5Hex(form.getPassword()));
		
		if(update) {
			try {
				if(userManager.updateUser(user)) {
					session.setAttribute("successMsg", "User successfully updated.");
				}
			} catch (Exception e) {
				session.setAttribute("errorMsg", e);
			}
		} else {
			try {
				if(userManager.saveUser(user)) {
					session.setAttribute("successMsg", "User successfully added.");
				}
			} catch (Exception e) {
				session.setAttribute("errorMsg", e);
				return "redirect:/user/new.htm";
			}
		}
		
		return HOME_PAGE;
	}
}
