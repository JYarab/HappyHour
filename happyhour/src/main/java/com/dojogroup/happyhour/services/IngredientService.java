package com.dojogroup.happyhour.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	public String listifyIngredients() {
//		List<String> strList = new ArrayList<String>();
//		strList.add("one");
//		strList.add("two");
//		strList.add("three");
//		for (int i = 0; i < strList.size(); i++) { 
//		return inStringList;
//	}



}
