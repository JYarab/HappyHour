package com.dojogroup.happyhour.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="drinks")

public class HappyHour {
	
	
	private Long id;


	private String drinkSearch;
	

	private String ingredients;
	
	private String drinkName;


	private String searchResults;
	

	private String randomDrink;
	
	public HappyHour() {
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrinkSearch() {
		return drinkSearch;
	}

	public void setDrinkSearch(String drinkSearch) {
		this.drinkSearch = drinkSearch;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public String getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(String searchResults) {
		this.searchResults = searchResults;
	}

	public String getRandomDrink() {
		return randomDrink;
	}

	public void setRandomDrink(String randomDrink) {
		this.randomDrink = randomDrink;
	}




	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(
				name = "favorites",
				joinColumns = @JoinColumn(name = "drink_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id")
				

				name = "reviews",
				joinColumns = @JoinColumn(name = "review_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id")
				
				)



				
		private List<User> favorites;
		

		public List<User> getFavorites() {
				return favorites;
		}
		
		public void setFavorites(List<User> favorites) {
			this.favorites = favorites;
		}
		

		private List<User> reviews;
		

		public List<User> getreviews() {
				return reviews;
		}
		
		public void setReviews(List<User> reviews) {
			this.reviews = reviews;
		}
		

		public User getUser() {
			return user;
		}
		
		public void setUser(User User) {
			this.user = User;
		}




}