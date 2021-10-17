package com.dojogroup.happyhour.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojogroup.happyhour.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	List<Ingredient> findAll();

	boolean existsByName(String name);

}
