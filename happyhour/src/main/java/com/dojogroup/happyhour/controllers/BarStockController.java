package com.dojogroup.happyhour.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojogroup.happyhour.models.Drink;
import com.dojogroup.happyhour.models.Ingredient;
import com.dojogroup.happyhour.services.IngredientService;
import com.dojogroup.happyhour.services.UserService;
import com.dojogroup.happyhour.utilities.DrinkApiCaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dojogroup.happyhour.models.User;
import com.dojogroup.happyhour.repositories.IngredientRepository;

@Controller
public class BarStockController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private IngredientService iService;
	@Autowired
	private IngredientRepository iRepo;

	@GetMapping("/happyhour/mybar")
	public String myBar(HttpSession session, Model viewModel) throws JsonMappingException, JsonProcessingException {
		if(session.getAttribute("loggedUser") == null) {
			return "redirect:/happyhour";
		}
		
//		if(session.getAttribute("allDrinks") == null) {
			
		
		RestTemplate restTemplate = new RestTemplate();	
		DrinkApiCaller apiCaller = new DrinkApiCaller();
		
		
		String resp = restTemplate.getForObject(apiCaller.searchDrinksByName(""), String.class);
		final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		final JsonNode jsonNode = objectMapper.readTree(resp);
		final JsonNode result = jsonNode.get("drinks");
		final Drink [] allDrinks = objectMapper.treeToValue(result, Drink [].class);
		
		session.setAttribute("allDrinks", allDrinks);
		
		//get user.barStock into viewModel AS List<String> for comparisons against the getIngredientList coming from Drink.java
		Long sessionId = (Long) session.getAttribute("loggedUser");
		User thisUser = uService.findUserById(sessionId);
		List<String> pantry=uService.getListIngredient(thisUser);
		viewModel.addAttribute("pantry", pantry);
//		System.out.println("pantry: "+pantry);
		viewModel.addAttribute("allDrinks", session.getAttribute("allDrinks"));
		viewModel.addAttribute("loggedUser", uService.findUserById((Long) session.getAttribute("loggedUser")));
		//analyze user's current barStock/pantry and generate list of smart suggestions from allDrinks based on easily attainable ingredients the user may not have listed.
		List<String> suggestions = iService.superSmartSuggestionator(allDrinks, pantry);
		viewModel.addAttribute("suggestions", suggestions);
//		}
		
		return "barStock.jsp";
	}
	
	
	@PostMapping("/happyhour/mybar/add")
	public String addToStock(@RequestParam("ingredient") String ingredName, HttpSession session, RedirectAttributes message) {
		if(iService.authenticateIngredient(ingredName, uService.findUserById((Long) session.getAttribute("loggedUser")))) {
			//if this returns true, the ingred is in the db. Add it to user.bar_stock
			Long sessionId = (Long) session.getAttribute("loggedUser");
	    	User thisUser = uService.findUserById(sessionId);
	    	Ingredient thisIngred = iService.findByName(ingredName);
	    	uService.addIngredient(thisUser, thisIngred);
	    	message.addFlashAttribute("message", "The item was added to your pantry");
	    	return "redirect:/happyhour/mybar";
		}
		//if ingredient authentication returns false, the ingred does not exist in db. serve error to user.
		message.addFlashAttribute("message", "this ingredient either doesn't exist in the db or you've already stocked it.");
    	return "redirect:/happyhour/mybar";
	}
	
}
