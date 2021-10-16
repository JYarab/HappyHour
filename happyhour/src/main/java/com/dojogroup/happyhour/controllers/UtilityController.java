package com.dojogroup.happyhour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.dojogroup.happyhour.models.Ingredient;
import com.dojogroup.happyhour.services.IngredientService;
import com.dojogroup.happyhour.utilities.DrinkApiCaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UtilityController {
	
	@Autowired
	private IngredientService iService;
	
	@RequestMapping("/happyhour/util/sqlLoad/importIngredients/{password}")
	public String importIngredients(@PathVariable(value="password") String password) throws JsonMappingException, JsonProcessingException {
		if(!password.contains("CodingDojo")) {
			return "redirect:/happyhour";
		}
		RestTemplate restTemplate = new RestTemplate();		
		DrinkApiCaller apiCaller = new DrinkApiCaller();
		String resp = restTemplate.getForObject(apiCaller.getIngredientList(), String.class);
		final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		final JsonNode jsonNode = objectMapper.readTree(resp);
		final JsonNode result = jsonNode.get("drinks");
		final Ingredient[] resultList = objectMapper.treeToValue(result, Ingredient[].class);
		
		iService.loadAll(resultList);
		
		return "/utils/dataLoaded.jsp";
	}
	
}
