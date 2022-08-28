package com.recipes.RecipeCentral.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "servings")
	private int servings;
	
	@Column(name = "ingredients")
	private String ingredients;
	
	@Column(name = "instructions")
	private String instructions;
	
	@Column(name = "creator")
	private String creator;
	
	@Column(name = "createdOn")
	private Date createdOn;
	
	public Recipe() {
		
	}
	

	public Recipe( String name, String type, int servings, String ingredients, String instructions,
			String creator, Date createdOn) {
		super();
		this.name = name;
		this.type = type;
		this.servings = servings;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.creator = creator;
		this.createdOn = createdOn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", type=" + type + ", servings=" + servings + ", ingredients="
				+ ingredients + ", instructions=" + instructions + ", creator=" + creator + ", createdOn=" + createdOn
				+ "]";
	}

}
