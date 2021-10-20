package com.dojogroup.happyhour.repositories;


	import java.util.List;


	import org.springframework.data.repository.CrudRepository;


	import com.dojogroup.happyhour.models.Drink;

	public interface DrinkRepository extends CrudRepository<Drink, Long> {
		
		List <Drink> findAll();
		
		Drink findById(String apiId);

	}


