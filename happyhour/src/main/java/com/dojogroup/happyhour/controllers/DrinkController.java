package com.dojogroup.happyhour.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.dojogroup.happyhour.models.Drink;
import com.dojogroup.happyhour.utilities.DrinkApiCaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class DrinkController {

	
	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping("")
	public String drinkSearch(@RequestParam(required = false, value="search") String search, @RequestParam(required = false, value="searchTerm") String searchTerm, Model viewModel) throws JsonMappingException, JsonProcessingException {
		
		if(search != null) {
			RestTemplate restTemplate = new RestTemplate();		
			DrinkApiCaller apiCaller = new DrinkApiCaller();
			String resp = restTemplate.getForObject(apiCaller.searchDrinksByName(searchTerm), String.class);
			System.out.println(resp); 
			final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final JsonNode jsonNode = objectMapper.readTree(resp);
			System.out.println(jsonNode);
			final JsonNode result = jsonNode.get("drinks");
			System.out.println(result);

			final Drink[] resultList = objectMapper.treeToValue(result, Drink[].class);
			
			System.out.println(resultList);
			
		//User's pantry will go here
			ArrayList<String> pantry = new ArrayList<String>(Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Ice", "Cream of coconut"));
			viewModel.addAttribute("pantry", pantry);
			
			viewModel.addAttribute("drinkList", resultList);
			for(Drink drink : resultList) {
				System.out.println(drink.getIngredientList());
			}
		}
		
		
		
		return "index.jsp";
	}
	
}