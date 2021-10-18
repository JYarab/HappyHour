package com.dojogroup.happyhour.services;

import java.util.List;
import java.util.Optional;

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
	
	public boolean authenticateIngredient(String ingredName) {
        // first find the ingredient by name
		Ingredient ingredient = iRepo.findByName(ingredName);
        // if we can't find it by name, return false
        if(ingredient == null) {
            return false;
        } else {
        	//other we've found the ingredient in the DB and can return true
        	return true;
        }
    }


}
