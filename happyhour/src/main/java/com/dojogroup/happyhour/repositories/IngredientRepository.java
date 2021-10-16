package com.dojogroup.happyhour.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojogroup.happyhour.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

	boolean existsByName(String name);

}
