package com.recipes.RecipeCentral;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeNoException;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.isNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Component;

import com.recipes.RecipeCentral.model.Recipe;
import com.recipes.RecipeCentral.service.RecipeService;

@Component
@SpringBootTest
class RecipeCentralApplicationTests {
	
	@Autowired
	private RecipeService service;
	
	private Recipe recipe;
	private Recipe newRecipe;
	private Recipe searchRecipe;

	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setup() {
		recipe = new Recipe("Pizza","vegeterian",2, "Flour,veggies,tomato,cheese","oven,sauce,cook","Jaya",new Date(2022,2,2));
		newRecipe = new Recipe("Pizza","non-vegeterian",2, "Flour,veggies,tomato,cheese,peproni","oven,sauce,cook","Jaya",new Date(2022,2,2));
		searchRecipe = new Recipe("","",-1,"veggies","cook","Jaya Jaiswal",new Date(2022,3,4));
	}
	
	@Test
	@DisplayName("Test adding a recipe")
	public void addRecipeTest() {
		Assertions.assertNotEquals(service.createRecipe(recipe),null);
	}
	
	@Test
	@DisplayName("Test recipes present")
	public void getRecipeTest(){
		Assertions.assertNotEquals(service.getRecipes().size(),  0);	
	}
	
	@Test
	@DisplayName("Test update a recipe")
	public void modifyRecipeTest() {
		Assertions.assertNotEquals(service.updateRecipe(1L,newRecipe),null);
	}
	
	@Test
	@DisplayName("Search a recipe having 'veggies' as ingredients and 'cook' as instruction")
	public void searchRecipeTest() {
		Assertions.assertNotEquals(service.searchRecipe(searchRecipe, true), null);
	}

}
