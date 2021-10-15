package com.dojogroup.happyhour.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojogroup.happyhour.models.User;
import com.dojogroup.happyhour.services.UserService;
import com.dojogroup.happyhour.validator.UserValidator;

@Controller
public class MainController {
	
	@Autowired UserValidator userValid;
	@Autowired UserService userService;
	
	//DASHBOARD
	@RequestMapping("/")
	public String redirHome() {
		return "redirect:/";
	}
	
	//VIEW LOGIN FORM / PAGE
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	//POST USER INFO FOR LOGIN VALIDATION AND ADD USER TO SESSION
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes errors) {
    	if(userService.authenticateUser(email, password)) {
    		User loggedUser = userService.findByEmail(email);
    		session.setAttribute("loggedUser", loggedUser.getId());
    		return "redirect:/happyhour";
    	} else {
    		errors.addFlashAttribute("error", "Credentials are invalid.");
    		return "redirect:/login";
    	}
	}
	
	//LOGOUT / TERMINATE SESSION
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
	
	//REGISTER NEW USER FORM / PAGE
	@RequestMapping("/register")
    public String registrationForm(@ModelAttribute("user") User user) {
        return "registration.jsp";
    }
	
	//POST USER INFO FOR REGISTRATION VALIDATION AND ADD USER TO DB. PUT USER IN SESSION AND REDIR TO 'INDEX'
	@RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValid.validate(user, result);
    	if(result.hasErrors()) {
    		return "registration.jsp";
    	} else {
    		userService.registerUser(user);
    		session.setAttribute("loggedUser", user.getId());
    		return "redirect:/index";
    	}
    }
	

}
