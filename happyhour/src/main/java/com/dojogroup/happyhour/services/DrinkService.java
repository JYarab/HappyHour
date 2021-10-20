package com.dojogroup.happyhour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojogroup.happyhour.models.Drink;
import com.dojogroup.happyhour.models.User;
import com.dojogroup.happyhour.repositories.DrinkRepository;




@Service

public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	

	public DrinkService(DrinkRepository repo) {
		drinkRepo = repo;
	}
	
	public List<Drink> allDrinks() {
		return drinkRepo.findAll();
		
	}
	

	public Drink findDrink(String apiId) { 
		return drinkRepo.findById(apiId);
	}
	
			


	public Drink getOneDrink(String apiId) {
		return drinkRepo.findById(apiId);
	}
	
	
	public void addFavDrink(Drink drink, User user) {
		List<User> favorites = drink.getFavorites();
		favorites.add(user);
		drinkRepo.save(drink);
		
	}
	
	public void removeFavorite(Drink drink, User user) {
		List<User> favorites = drink.getFavorites();
		favorites.remove(user);
		drinkRepo.save(drink);
	}

}
