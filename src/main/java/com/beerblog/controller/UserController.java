package main.java.com.beerblog.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.com.beerblog.entity.User;
import main.java.com.beerblog.service.EntryService;
import main.java.com.beerblog.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EntryService entryService;
	
	@ModelAttribute("user") // <form:form commandName="user">
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/users.html")
	public String users(Model model){
		// loading data from database
		model.addAttribute("entries", entryService.findAll());	
		model.addAttribute("users", userService.findAll());
		
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOne(id));
		return "user-detail";
	}
	
	// testing in register
	@RequestMapping("/register")
	public String showRegister(Model model){
		
		model.addAttribute("bambucha", entryService.findAll());
		model.addAttribute("users", userService.findAll());
		
		return "user-register";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		user.setRegistrationDate(new Date());
		userService.save(user);
		return "redirect:/register.html?insert_successful=true"; 
		// changed from 'user-register' to redirect:/register to achieve proper refreshing
		// insert_successful shows message after successful registration
	}
	
	@RequestMapping("/delete/{id}")
	public String deletingUser(@ModelAttribute("user") User user, @PathVariable int id){
		userService.delete(id);
		return "redirect:/register.html";
	}
}
