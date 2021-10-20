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
	
	//measurements
	@JsonProperty("strMeasure1")
	private String measure1;
	
	@JsonProperty("strMeasure2")
	private String measure2;
	
	@JsonProperty("strMeasure3")
	private String measure3;
	
	@JsonProperty("strMeasure4")
	private String measure4;
	
	@JsonProperty("strMeasure5")
	private String measure5;
	
	@JsonProperty("strMeasure6")
	private String measure6;
	
	@JsonProperty("strMeasure7")
	private String measure7;
	
	@JsonProperty("strMeasure8")
	private String measure8;
	
	@JsonProperty("strMeasure9")
	private String measure9;
	
	@JsonProperty("strMeasure10")
	private String measure10;
	
	@JsonProperty("strMeasure11")
	private String measure11;
	
	@JsonProperty("strMeasure12")
	private String measure12;
	
	@JsonProperty("strMeasure13")
	private String measure13;
	
	@JsonProperty("strMeasure14")
	private String measure14;
	
	@JsonProperty("strMeasure15")
	private String measure15;
	
	Drink(){
		
	}
	// making measurements
	public List<String> getMeasurements(){
	ArrayList<String> newList = new ArrayList<String>();
	
	if( this.measure1 != null) {
		newList.add(this.measure1.toLowerCase());
	}
	
	if( this.measure2 != null) {
		newList.add(this.measure2.toLowerCase());
	}
	
	if( this.measure3 != null) {
		newList.add(this.measure3.toLowerCase());
	}
	
	if( this.measure4 != null) {
		newList.add(this.measure4.toLowerCase());
	}
	
	if( this.measure5 != null) {
		newList.add(this.measure5.toLowerCase());
	}
	
	if( this.measure6 != null) {
		newList.add(this.measure6.toLowerCase());
	}
	
	if( this.measure7 != null) {
		newList.add(this.measure7.toLowerCase());
	}
	
	if( this.measure8 != null) {
		newList.add(this.measure8.toLowerCase());
	}
	
	if( this.measure9 != null) {
		newList.add(this.measure9.toLowerCase());
	}
	
	if( this.measure10 != null) {
		newList.add(this.measure10.toLowerCase());
	}
	
	if( this.measure11 != null) {
		newList.add(this.measure11.toLowerCase());
	}
	
	if( this.measure12 != null) {
		newList.add(this.measure12.toLowerCase());
	}
	
	if( this.measure13 != null) {
		newList.add(this.measure13.toLowerCase());
	}
	
	if( this.measure14 != null) {
		newList.add(this.measure14.toLowerCase());
	}
	
	if( this.measure15 != null) {
		newList.add(this.measure15.toLowerCase());
	}
	return newList;
	}
	
	public List<String> getIngredientList() {
		ArrayList<String> newList = new ArrayList<String>();		
		if( this.ingredient1 != null) {
			newList.add(this.ingredient1.toLowerCase());
		}
		if( this.ingredient2 != null) {
			newList.add(this.ingredient2.toLowerCase());
		}
		if( this.ingredient3 != null) {
			newList.add(this.ingredient3.toLowerCase());
		}
		if( this.ingredient4 != null) {
			newList.add(this.ingredient4.toLowerCase());
		}
		if( this.ingredient5 != null) {
			newList.add(this.ingredient5.toLowerCase());
		}
		if( this.ingredient6 != null) {
			newList.add(this.ingredient6.toLowerCase());
		}
		if( this.ingredient7 != null) {
			newList.add(this.ingredient7.toLowerCase());
		}
		if( this.ingredient8 != null) {
			newList.add(this.ingredient8.toLowerCase());
		}
		if( this.ingredient9 != null) {
			newList.add(this.ingredient9.toLowerCase());
		}
		if( this.ingredient10 != null) {
			newList.add(this.ingredient10.toLowerCase());
		}
		if( this.ingredient11 != null) {
			newList.add(this.ingredient11.toLowerCase());
		}
		if( this.ingredient12 != null) {
			newList.add(this.ingredient12.toLowerCase());
		}
		if( this.ingredient13 != null) {
			newList.add(this.ingredient13.toLowerCase());
		}
		if( this.ingredient14 != null) {
			newList.add(this.ingredient14.toLowerCase());
		}
		if( this.ingredient15 != null) {
			newList.add(this.ingredient15.toLowerCase());
		}
					
		return newList;
		
		
	}
	
	public List<String> getIngredMeasure(){
	ArrayList<String> newList = new ArrayList<String>();
	
	if( this.measure1 != null) {
		newList.add(this.measure1.toLowerCase());
	}
	if( this.ingredient1 != null) {
		newList.add(this.ingredient1.toLowerCase());
	}
	
	if( this.measure2 != null) {
		newList.add(this.measure2.toLowerCase());
	}
	
	if( this.ingredient2 != null) {
		newList.add(this.ingredient2.toLowerCase());
	}
	
	if( this.measure3 != null) {
		newList.add(this.measure3.toLowerCase());
	}
	
	if( this.ingredient3 != null) {
		newList.add(this.ingredient3.toLowerCase());
	}
	
	if( this.measure4 != null) {
		newList.add(this.measure4.toLowerCase());
	}
	if( this.ingredient4 != null) {
		newList.add(this.ingredient4.toLowerCase());
	}
	
	if( this.measure5 != null) {
		newList.add(this.measure5.toLowerCase());
	}	
	if( this.ingredient5 != null) {
		newList.add(this.ingredient5.toLowerCase());
	}
	
	if( this.measure6 != null) {
		newList.add(this.measure6.toLowerCase());
	}
	if( this.ingredient6 != null) {
		newList.add(this.ingredient6.toLowerCase());
	}
	
	if( this.measure7 != null) {
		newList.add(this.measure7.toLowerCase());
	}
	if( this.ingredient7 != null) {
		newList.add(this.ingredient7.toLowerCase());
	}
	
	if( this.measure8 != null) {
		newList.add(this.measure8.toLowerCase());
	}
	if( this.ingredient8 != null) {
		newList.add(this.ingredient8.toLowerCase());
	}
	
	if( this.measure9 != null) {
		newList.add(this.measure9.toLowerCase());
	}
	if( this.ingredient9 != null) {
		newList.add(this.ingredient9.toLowerCase());
	}
	
	if( this.measure10 != null) {
		newList.add(this.measure10.toLowerCase());
	}
	if( this.ingredient10 != null) {
		newList.add(this.ingredient10.toLowerCase());
	}
	
	if( this.measure11 != null) {
		newList.add(this.measure11.toLowerCase());
	}
	if( this.ingredient11 != null) {
		newList.add(this.ingredient11.toLowerCase());
	}
	
	if( this.measure12 != null) {
		newList.add(this.measure12.toLowerCase());
	}
	if( this.ingredient12 != null) {
		newList.add(this.ingredient12.toLowerCase());
	}
	
	if( this.measure13 != null) {
		newList.add(this.measure13.toLowerCase());
	}
	if( this.ingredient13 != null) {
		newList.add(this.ingredient13.toLowerCase());
	}
	
	if( this.measure14 != null) {
		newList.add(this.measure14.toLowerCase());
	}
	if( this.ingredient14 != null) {
		newList.add(this.ingredient14.toLowerCase());
	}
	
	if( this.measure15 != null) {
		newList.add(this.measure15.toLowerCase());
	}
	if( this.ingredient15 != null) {
		newList.add(this.ingredient15.toLowerCase());
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

	public String getMeasure1() {
		return measure1;
	}
	public void setMeasure1(String measure1) {
		this.measure1 = measure1;
	}
	public String getMeasure2() {
		return measure2;
	}
	public void setMeasure2(String measure2) {
		this.measure2 = measure2;
	}
	public String getMeasure3() {
		return measure3;
	}
	public void setMeasure3(String measure3) {
		this.measure3 = measure3;
	}
	public String getMeasure4() {
		return measure4;
	}
	public void setMeasure4(String measure4) {
		this.measure4 = measure4;
	}
	public String getMeasure5() {
		return measure5;
	}
	public void setMeasure5(String measure5) {
		this.measure5 = measure5;
	}
	public String getMeasure6() {
		return measure6;
	}
	public void setMeasure6(String measure6) {
		this.measure6 = measure6;
	}
	public String getMeasure7() {
		return measure7;
	}
	public void setMeasure7(String measure7) {
		this.measure7 = measure7;
	}
	public String getMeasure8() {
		return measure8;
	}
	public void setMeasure8(String measure8) {
		this.measure8 = measure8;
	}
	public String getMeasure9() {
		return measure9;
	}
	public void setMeasure9(String measure9) {
		this.measure9 = measure9;
	}
	public String getMeasure10() {
		return measure10;
	}
	public void setMeasure10(String measure10) {
		this.measure10 = measure10;
	}
	public String getMeasure11() {
		return measure11;
	}
	public void setMeasure11(String measure11) {
		this.measure11 = measure11;
	}
	public String getMeasure12() {
		return measure12;
	}
	public void setMeasure12(String measure12) {
		this.measure12 = measure12;
	}
	public String getMeasure13() {
		return measure13;
	}
	public void setMeasure13(String measure13) {
		this.measure13 = measure13;
	}
	public String getMeasure14() {
		return measure14;
	}
	public void setMeasure14(String measure14) {
		this.measure14 = measure14;
	}
	public String getMeasure15() {
		return measure15;
	}
	public void setMeasure15(String measure15) {
		this.measure15 = measure15;
	}
	
}

