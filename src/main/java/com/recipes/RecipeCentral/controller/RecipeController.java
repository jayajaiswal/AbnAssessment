package com.recipes.RecipeCentral.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.RecipeCentral.model.Recipe;
import com.recipes.RecipeCentral.service.RecipeService;

import ch.qos.logback.core.boolex.Matcher;

@RestController
@RequestMapping("/api")
public class RecipeController {
	
	@Autowired
	RecipeService service;
	
	
	@RequestMapping(value = "/addRecipe",method = RequestMethod.POST)
	public ResponseEntity addRecipe(@RequestBody Recipe recipe) {
		
		try {
		service.createRecipe(recipe);
		return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
		}
		catch(Exception e) {
			return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating recipe");
		}
		
	
	}

	@RequestMapping(value = "/getRecipe",method = RequestMethod.GET)
	public List<Recipe> getRecipe() {
		
		return service.getRecipes();
	}
	
	@RequestMapping(value = "/removeRecipe/{id}",method = RequestMethod.DELETE)
	public ResponseEntity deleteRecipe(@PathVariable(value = "id") String id) {
		try {
		service.deleteRecipe(Long.parseLong(id));
		return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
		}
		catch(Exception e) {
			return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Recipe not found");

		}
	}
	
	@RequestMapping(value = "updateRecipe/{id}", method = RequestMethod.PUT)
	public Recipe updateRecipe(@PathVariable(value = "id") String id, @RequestBody Recipe newRecipe) {
		
		return service.updateRecipe(Long.parseLong(id), newRecipe);
	}
	
	@RequestMapping(value = "searchRecipe/{isPresent}", method = RequestMethod.POST)
	public List<Recipe> getUsersList( @RequestBody Recipe recipeReq, @PathVariable(value = "isPresent") Boolean isPresent) {
    
		return service.searchRecipe(recipeReq,isPresent);		
	}
	
}
	