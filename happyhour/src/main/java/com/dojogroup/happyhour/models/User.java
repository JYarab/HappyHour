package com.dojogroup.happyhour.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=255, message="First name must be at least 2 characters")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=255, message="Last name must be at least 2 characters")
	private String lastName;
	
	@Email(message="Invalid email address")
	private String email;
	
	@Size(min=5, message="Password must be greater than 5 characters")
	private String password;
	
	@Transient
	private String pwConfirmation;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date createdAt;
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date updatedAt;
	
	//AUTOGEN CREATE/UPDATE TIMESTAMPS
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "user_ingredient", 
	    joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "ingredient_id")
	)
	 private List<Ingredient> bar_stock;
    
    //CONSTRUCTOR
    public User() {
	}
    
    //GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwConfirmation() {
		return pwConfirmation;
	}
	public void setPwConfirmation(String pwConfirmation) {
		this.pwConfirmation = pwConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Ingredient> getBar_stock() {
		return bar_stock;
	}
	public void setBar_stock(List<Ingredient> bar_stock) {
		this.bar_stock = bar_stock;
	}

	

}