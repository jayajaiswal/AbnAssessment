package com.recipes.RecipeCentral.repository;

import org.springframework.stereotype.Repository;

import com.recipes.RecipeCentral.model.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>  ,JpaSpecificationExecutor<Recipe> {

}
