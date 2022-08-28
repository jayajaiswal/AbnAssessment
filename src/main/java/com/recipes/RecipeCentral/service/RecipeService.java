package com.recipes.RecipeCentral.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.recipes.RecipeCentral.model.Recipe;
import com.recipes.RecipeCentral.model.RecipeSpecification;
import com.recipes.RecipeCentral.repository.RecipeRepository;

@Service
public class RecipeService{
	
	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
    private RecipeSpecification recipeSpecification;

	// CREATE 
	public Recipe createRecipe(Recipe recipe) {
		System.out.println("inside service");
	    return recipeRepo.save(recipe);
	}

	// READ
	public List<Recipe> getRecipes() {
	    return recipeRepo.findAll();
	}

	// DELETE
	public void deleteRecipe(Long id) {
	    recipeRepo.deleteById(id);
	}
	
	// UPDATE
	public Recipe updateRecipe(Long id, Recipe newRecipe) {
	        Recipe recipe = recipeRepo.findById(id).get();
	        recipe.setName(newRecipe.getName());
	        recipe.setServings(newRecipe.getServings());
	        recipe.setType(newRecipe.getType());
	        recipe.setIngredients(newRecipe.getIngredients());
	        recipe.setInstructions(newRecipe.getInstructions());
	        recipe.setCreator(newRecipe.getCreator());
	        recipe.setCreatedOn(newRecipe.getCreatedOn());
	        
	        return recipeRepo.save(recipe);                                
	}
	
	//SEARCH
	
	public List<Recipe> searchRecipe(Recipe recipeReq, Boolean isPresent){
		
		List<Recipe> result = recipeRepo.findAll(recipeSpecification.getRecipes(recipeReq,isPresent));
		return result;
	}
	
	
	/*
	 * public Specification<Recipe> searchRecipeByType(String type,Boolean
	 * isPresent){ if(isPresent) { return (root, query, criteriaBuilder) ->
	 * criteriaBuilder.equal(root.get(type), type); } else return (root, query,
	 * criteriaBuilder) -> criteriaBuilder.notEqual(root.get("type"), type);
	 * 
	 * }
	 * 
	 * public Specification<Recipe> searchRecipeByServings(int servingsSize){
	 * 
	 * return (root, query, criteriaBuilder) ->
	 * criteriaBuilder.equal(root.get("servings"), servingsSize);
	 * 
	 * }
	 * 
	 * public Specification<Recipe> searchRecipeByIngredients(String ingredient){
	 * 
	 * return (root, query, criteriaBuilder) ->
	 * criteriaBuilder.like(root.get("ingredients"), "%"+ingredient+"%");
	 * 
	 * }
	 * 
	 * public Specification<Recipe> searchRecipeByInstructions(String instruction){
	 * 
	 * return (root, query, criteriaBuilder) ->
	 * criteriaBuilder.like(root.get("instructions"), "%"+instruction+"%");
	 * 
	 * }
	 * 
	 * public List<Recipe> searchByServingAndIngredient(int servingSize, String
	 * ingredient) {
	 * 
	 * return
	 * recipeRepo.findAll(Specification.where(searchRecipeByServings(servingSize).
	 * and(searchRecipeByIngredients(ingredient)))); }
	 * 
	 * public List<Recipe> searchByServingAndType(int servingSize, String type,
	 * Boolean isPresent) {
	 * 
	 * return
	 * recipeRepo.findAll(Specification.where(searchRecipeByServings(servingSize).
	 * and(searchRecipeByType(type,isPresent)))); }
	 * 
	 * public List<Recipe> searchByTypeAndInstructions(String instruction, String
	 * type, Boolean isPresent) {
	 * 
	 * return
	 * recipeRepo.findAll(Specification.where(searchRecipeByType(type,isPresent)).
	 * and(searchRecipeByInstructions(instruction))); }
	 * 
	 * public List<Recipe> searchByIngredientAndInstruction(String ingredient,
	 * String instruction) {
	 * 
	 * return
	 * recipeRepo.findAll(Specification.where(searchRecipeByIngredients(ingredient).
	 * and(searchRecipeByInstructions(instruction)))); }
	 */
	
	
	
	
}
