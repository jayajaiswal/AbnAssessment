package com.recipes.RecipeCentral.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeSpecification {

	public Specification<Recipe> getRecipes(Recipe recipeReq, Boolean isPresent){
		
		return (root,query,criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			 if (recipeReq.getType() != null && !recipeReq.getType().isEmpty() && isPresent) {
				 predicates.add(criteriaBuilder.equal(root.get("type"), recipeReq.getType()));
		}
			 if(recipeReq.getType() != null && !recipeReq.getType().isEmpty() && !isPresent) {
				 predicates.add(criteriaBuilder.notEqual(root.get("type"), recipeReq.getType()));
			 }
			 if(recipeReq.getServings() > 0 ) {
				 predicates.add(criteriaBuilder.equal(root.get("servings"), recipeReq.getServings()));
			 }
			 if(recipeReq.getIngredients() != null  && !recipeReq.getIngredients().isEmpty()) {
				 predicates.add(criteriaBuilder.like(root.get("ingredients"), "%"+recipeReq.getIngredients()+"%"));

			 }
			 if(recipeReq.getInstructions() != null  && !recipeReq.getInstructions().isEmpty()) {
				 predicates.add(criteriaBuilder.like(root.get("instructions"), "%"+recipeReq.getInstructions()+"%"));

			 }
			 
			 query.orderBy(criteriaBuilder.asc(root));
			 return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	};
}
}
