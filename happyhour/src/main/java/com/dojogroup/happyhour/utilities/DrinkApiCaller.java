package com.dojogroup.happyhour.utilities;

public class DrinkApiCaller {
	
	private String apiKey = "PUT API KEY HERE";
	
	private String baseUrl = "https://www.thecocktaildb.com/api/json/v2/"+apiKey;
	
	//returns list of matching drinks w/ full details or {"drinks":null}
	public String searchDrinksByName(String name) {
		return baseUrl+"/search.php?s="+name;
	}
	
	//returns list of matching drinks w/ only name, id# and thumbImg url or {"drinks":"None Found"}
	public String searchDrinksByIngredient(String name) {
		return baseUrl+"/filter.php?i="+name;
	}
	
	//returns a list of drinks with full details or {"drinks":null} ***FAILS WITH NO RETURN IF MORE THAN ONE CHAR SENT*****
	public String listDrinksByFirstLetter(Character firstLetter) {
		return baseUrl+"search.php?f="+firstLetter;
	}
	
	//returns 1 ingredient with full details or {"ingredients":null} Does NOT return partial matches just first match ie... b only returns beer
	public String searchIngredientByName(String name) {
		return baseUrl+"/search.php?i="+name;
	}
	
	//returns 1 drink with full details or {"drinks":null}
	public String lookupDrinkById(String id) {
		return baseUrl+"/lookup.php?i="+id;
	}
	
	//returns 1 Ingredient with full details or {"ingredients":null}
	public String lookupIngredientById(String id) {
		return baseUrl+"/lookup.php?iid="+id;
	}
	
	//Returns 1 random drink with full details
	public String getOneRandomDrink() {
		return baseUrl+"/random.php";
	}
	
	//Returns 10 random drinks 
	public String get10RandomDrinks() {
		return baseUrl+"/randomselection.php";
	}
	
	//Returns 20 popular drinks 
	public String getPopularDrinks() {
		return baseUrl+"/popular.php";
	}
	
	//Returns 10 latest drinks 
	public String getLatestDrinks() {
		return baseUrl+"/latest.php";
	}
	

}
