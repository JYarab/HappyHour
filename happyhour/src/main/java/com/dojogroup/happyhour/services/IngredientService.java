package com.dojogroup.happyhour.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojogroup.happyhour.models.Ingredient;
import com.dojogroup.happyhour.repositories.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository iRepo;
	
	
	public void loadAll(Ingredient[] resultList) {
		for(Ingredient i : resultList) {
			if(!iRepo.existsByName(i.getName())) {
				iRepo.save(i);
			}
		}
	}


}
