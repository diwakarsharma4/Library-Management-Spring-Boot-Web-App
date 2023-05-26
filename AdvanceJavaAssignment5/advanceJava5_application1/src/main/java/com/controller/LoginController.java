package com.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.SignUpDao;
import com.entities.Credentials;
import com.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	private SignUpDao signUpDao;
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/signup")
	public String register() {
		return "signup";
	}
	
	
	  
	  
//	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
//	public String handleLoginForm(@ModelAttribute Credentials credentials, Model model) {
//		System.out.println(credentials);
//		if(!userService.validateUser(credentials)) {			
//			model.addAttribute("msg", "Username and password doesn't exist please register");
//			return "signup";
//		}else {
//			model.addAttribute("msg","Successfully logged in");
//			System.out.println(model);
//			return "home";
//		}
//	}
	
	
	
	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
	public RedirectView handleLoginForm(@ModelAttribute Credentials credentials, Model model) {
		System.out.println(credentials);
		if(!userService.validateUser(credentials)) {			
			model.addAttribute("msg", "Username and password doesn't exist please register");
			String url = "http://localhost:8080/advanceJava5_application1/signup";
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(url);
			return redirectView;
			
		}else {
//			model.addAttribute("msg","Successfully logged in");
			System.out.println(model);
			String url = "http://localhost:8080/advanceJava5_application2/";
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(url);
			return redirectView;
		}
	}
		
	
	@RequestMapping(path = "/redirectToLib", method = RequestMethod.GET)
	public RedirectView redirect(){
		String url = "http://localhost:8080/advanceJava5_application2/";
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	

	
//	@RequestMapping(path="/fillForm",method = RequestMethod.POST)
//	public String handleRegisterForm(@ModelAttribute Credentials credentials, Model model) {
//		System.out.println(credentials);
//	    this.userService.createUser(credentials);
//	    model.addAttribute("msg", "Successfully registerd");
//		return "home";
//	}
	
	
	
	@RequestMapping(path="/fillForm",method = RequestMethod.POST)
	public RedirectView handleRegisterForm(@ModelAttribute Credentials credentials, Model model) {
		String url = "http://localhost:8080/advanceJava5_application2/";
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
	    this.userService.createUser(credentials);
//	    model.addAttribute("msg", "Successfully registerd");
		return redirectView;
	}
	
}
