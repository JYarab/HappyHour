package com.dojogroup.happyhour.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="drink")
public class Drink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
		
	@JsonProperty("strDrink")
	private String name;
	
	@JsonProperty("strDrinkThumb")
	private String imgThumb;
	
	@JsonProperty("idDrink")
	private String apiId;
	
	@JsonProperty("strInstructions")
	private String instructions;
	
	@JsonProperty("strIngredient1")
	private String ingredient1;
	
	@JsonProperty("strIngredient2")
	private String ingredient2;
	
	@JsonProperty("strIngredient3")
	private String ingredient3;
	
	@JsonProperty("strIngredient4")
	private String ingredient4;
	
	@JsonProperty("strIngredient5")
	private String ingredient5;
	
	@JsonProperty("strIngredient6")
	private String ingredient6;
	
	@JsonProperty("strIngredient7")
	private String ingredient7;
	
	@JsonProperty("strIngredient8")
	private String ingredient8;
	
	@JsonProperty("strIngredient9")
	private String ingredient9;
	
	@JsonProperty("strIngredient10")
	private String ingredient10;
	
	@JsonProperty("strIngredient11")
	private String ingredient11;
	
	@JsonProperty("strIngredient12")
	private String ingredient12;
	
	@JsonProperty("strIngredient13")
	private String ingredient13;
	
	@JsonProperty("strIngredient14")
	private String ingredient14;
	
	@JsonProperty("strIngredient15")
	private String ingredient15;


	
	Drink(){
		
	}
	
	
	
	public List<String> getIngredientList() {
		ArrayList<String> newList = new ArrayList<String>();		
		if( this.ingredient1 != null) {
			newList.add(this.ingredient1);
		}
		if( this.ingredient2 != null) {
			newList.add(this.ingredient2);
		}
		if( this.ingredient3 != null) {
			newList.add(this.ingredient3);
		}
		if( this.ingredient4 != null) {
			newList.add(this.ingredient4);
		}
		if( this.ingredient5 != null) {
			newList.add(this.ingredient5);
		}
		if( this.ingredient6 != null) {
			newList.add(this.ingredient6);
		}
		if( this.ingredient7 != null) {
			newList.add(this.ingredient7);
		}
		if( this.ingredient8 != null) {
			newList.add(this.ingredient8);
		}
		if( this.ingredient9 != null) {
			newList.add(this.ingredient9);
		}
		if( this.ingredient10 != null) {
			newList.add(this.ingredient10);
		}
		if( this.ingredient11 != null) {
			newList.add(this.ingredient11);
		}
		if( this.ingredient12 != null) {
			newList.add(this.ingredient12);
		}
		if( this.ingredient13 != null) {
			newList.add(this.ingredient13);
		}
		if( this.ingredient14 != null) {
			newList.add(this.ingredient14);
		}
		if( this.ingredient15 != null) {
			newList.add(this.ingredient15);
		}
					
		return newList;
	}
	

	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getImgThumb() {
		return imgThumb;
	}




	public void setImgThumb(String imgThumb) {
		this.imgThumb = imgThumb;
	}




	public String getApiId() {
		return apiId;
	}




	public void setApiId(String apiId) {
		this.apiId = apiId;
	}




	public String getInstructions() {
		return instructions;
	}


	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


	public String getIngredient1() {
		return ingredient1;
	}




	public void setIngredient1(String ingredient1) {
		this.ingredient1 = ingredient1;
	}




	public String getIngredient2() {
		return ingredient2;
	}




	public void setIngredient2(String ingredient2) {
		this.ingredient2 = ingredient2;
	}




	public String getIngredient3() {
		return ingredient3;
	}




	public void setIngredient3(String ingredient3) {
		this.ingredient3 = ingredient3;
	}




	public String getIngredient4() {
		return ingredient4;
	}




	public void setIngredient4(String ingredient4) {
		this.ingredient4 = ingredient4;
	}




	public String getIngredient5() {
		return ingredient5;
	}




	public void setIngredient5(String ingredient5) {
		this.ingredient5 = ingredient5;
	}




	public String getIngredient6() {
		return ingredient6;
	}




	public void setIngredient6(String ingredient6) {
		this.ingredient6 = ingredient6;
	}




	public String getIngredient7() {
		return ingredient7;
	}




	public void setIngredient7(String ingredient7) {
		this.ingredient7 = ingredient7;
	}




	public String getIngredient8() {
		return ingredient8;
	}




	public void setIngredient8(String ingredient8) {
		this.ingredient8 = ingredient8;
	}




	public String getIngredient9() {
		return ingredient9;
	}




	public void setIngredient9(String ingredient9) {
		this.ingredient9 = ingredient9;
	}




	public String getIngredient10() {
		return ingredient10;
	}




	public void setIngredient10(String ingredient10) {
		this.ingredient10 = ingredient10;
	}




	public String getIngredient11() {
		return ingredient11;
	}




	public void setIngredient11(String ingredient11) {
		this.ingredient11 = ingredient11;
	}




	public String getIngredient12() {
		return ingredient12;
	}




	public void setIngredient12(String ingredient12) {
		this.ingredient12 = ingredient12;
	}




	public String getIngredient13() {
		return ingredient13;
	}




	public void setIngredient13(String ingredient13) {
		this.ingredient13 = ingredient13;
	}




	public String getIngredient14() {
		return ingredient14;
	}




	public void setIngredient14(String ingredient14) {
		this.ingredient14 = ingredient14;
	}




	public String getIngredient15() {
		return ingredient15;
	}




	public void setIngredient15(String ingredient15) {
		this.ingredient15 = ingredient15;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "user_favorite", 
	    joinColumns = @JoinColumn(name = "drink_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	
			)
	

	
	private List<User> favorites;
	

	public List<User> getFavorites() {
			return favorites;
	}
	
	public void setFavorites(List<User> favorites) {

		this.favorites = favorites;
	}
	

	
	public User getUser() {
		return user;
	}
	
	public void setUser(User User) {
		this.user = User;
	}

	
	
}

