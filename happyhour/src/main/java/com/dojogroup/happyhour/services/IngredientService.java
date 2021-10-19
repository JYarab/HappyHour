package com.dojogroup.happyhour.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojogroup.happyhour.models.Drink;
import com.dojogroup.happyhour.models.Ingredient;
import com.dojogroup.happyhour.models.User;
import com.dojogroup.happyhour.repositories.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository iRepo;
	
	
	public Ingredient findIngredById(Long id) {
		Optional<Ingredient> i = iRepo.findById(id);
		if(i.isPresent()) {
			return i.get();
		} else {
			return null;
		}
	}
	
	public void loadAll(Ingredient[] resultList) {
		for(Ingredient i : resultList) {
			if(!iRepo.existsByName(i.getName())) {
				iRepo.save(i);
			}
		}
	}

	public Ingredient findByName(String ingredient) {
		return iRepo.findByName(ingredient);
	}
	
	public boolean authenticateIngredient(String ingredName, User user) {
        // first find the ingredient by name
		Ingredient ingredient = iRepo.findByName(ingredName);
        // if we can't find it by name, return false
        if(ingredient == null) {
            return false;
        }
        //or if the ingredient has already been added to this user's pantry, send false
        if(user.getBar_stock().contains(ingredient)){
        	return false;
        } else {
        //otherwise, the ingred both exists in DB and not in user pantry. Return true.
        	return true;
        }
    }

	public List<String> superSmartSuggestionator(Drink[] allDrinks, List<String> pantry){
		ArrayList<String> allSuggestions = new ArrayList<String>();
//		ArrayList<String> matchCounter = new ArrayList<String>();
		for(Drink drink : allDrinks) {
			List<String> uniqueList = new ArrayList<String>();
			List<String> drinkIngreds = drink.getIngredientList();
			uniqueList.add(drink.getName());
			System.out.println("drink array: "+drinkIngreds);
			
			for(int i = 0; i < drinkIngreds.size();i++) {
				if(pantry.contains(drinkIngreds.get(i))){
					continue;
				} else {
					uniqueList.add(drinkIngreds.get(i));
					System.out.println("this is whats passing: "+drinkIngreds.get(i));
				}
		
			}
			System.out.println("unique ingredients are: "+uniqueList);
			if(uniqueList.size() == 2) {
				allSuggestions.add("you need: "+ uniqueList.get(1)+" to make a "+uniqueList.get(0)+"!");
//				matchCounter.add(uniqueList.get(1));
				System.out.println("you only need "+uniqueList.get(1)+" to make a "+uniqueList.get(0)+"!");
			} else {
				continue;
			}
			
		}
//		for(int i = 0; i < matchCounter.size();i++) {
//			if(matchCounter.get(i).contentEquals("milk")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lemon")) {
//				System.out.println("With just some "+matchCounter.get(i)+"s you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("bitters")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("berries")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("brown sugar")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lime")) {
//				System.out.println("With just some "+matchCounter.get(i)+"s you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lemon juice")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lime juice")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("cider")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("honey")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("club soda")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("coca-cola")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("cola")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("blueberries")) {
//				System.out.println("With just some "+matchCounter.get(i)+"s you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lemon juice")) {
//				System.out.println("With just some "+matchCounter.get(i)+" you can make it!");
//			}
//			if(matchCounter.get(i).contentEquals("lime juice")) {
//				System.out.println("With just some "+matchCounter.get(i)+"s you can make it!");
//			} else {
//				continue;
//			}
//		}
		
		System.out.println(allSuggestions.size());
		System.out.println(allSuggestions);
		return allSuggestions;
	}

}
