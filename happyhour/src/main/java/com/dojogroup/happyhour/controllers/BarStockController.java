package com.dojogroup.happyhour.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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

@Controller
public class BarStockController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private IngredientService iService;

	@GetMapping("/happyhour/mybar")
	public String myBar(@ModelAttribute("ingredient") Ingredient ingredient, HttpSession session, Model viewModel) throws JsonMappingException, JsonProcessingException {
		if(session.getAttribute("loggedUser") == null) {
			return "redirect:/happyhour";
		}
		
		if(session.getAttribute("allDrinks") == null) {
			
		
		RestTemplate restTemplate = new RestTemplate();	
		DrinkApiCaller apiCaller = new DrinkApiCaller();
		
		
		String resp = restTemplate.getForObject(apiCaller.searchDrinksByName(""), String.class);
		final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		final JsonNode jsonNode = objectMapper.readTree(resp);
		final JsonNode result = jsonNode.get("drinks");
		final Drink [] allDrinks = objectMapper.treeToValue(result, Drink [].class);
		
		session.setAttribute("allDrinks", allDrinks);
		}
		
		//User's pantry will go here
		ArrayList<String> pantry = new ArrayList<String>(Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Ice", "Cream of coconut"));
		viewModel.addAttribute("pantry", pantry);
		
		viewModel.addAttribute("allDrinks", session.getAttribute("allDrinks"));
		viewModel.addAttribute("user", uService.findUserById((Long) session.getAttribute("loggedUser")));
		
		return "barStock.jsp";
	}
	
	
	@PostMapping("/happyhour/mybar/add")
	public String addToStock(@PathVariable("id") String id, HttpSession session, Model viewModel) {
		return "redirect:/happyhour";
	}
}
