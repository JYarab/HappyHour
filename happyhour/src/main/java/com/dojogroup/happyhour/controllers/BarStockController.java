package com.dojogroup.happyhour.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.dojogroup.happyhour.models.Drink;
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

	@GetMapping("/happyhour/mybar")
	public String myBar(HttpSession session, Model viewModel) throws JsonMappingException, JsonProcessingException {
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
}
