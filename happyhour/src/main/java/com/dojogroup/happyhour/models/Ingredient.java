package com.dojogroup.happyhour.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name="ingredients")
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("strIngredient1")
	private String name;
	
	@JsonProperty("idIngredient")
	private String apiId;
	
	@JsonProperty("strDescription")
	private String description;
	
	@JsonProperty("strType")
	private String type;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "user_ingredient", 
	    joinColumns = @JoinColumn(name = "ingredient_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	 private List<User> users;
	
	Ingredient (){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
