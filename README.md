# Recipe Central
A standalone java application called "Recipe Central" which allows users to manage their favourite recipes using Java, Spring boot, maven and Junit.
The service uses RecipeSpecification to allow multiple searches using JPA Sepcification and predicates which are used by criteria Builder to build the search query.
The database used is MySql and test cases are written using junit and mockito.

Recipe class with fields-
> Name
> Type
> Servings
> Ingredients
> Instructions
> Creator
> CreatedOn

Features
1. addRecipe - http://localhost:8080/api/addRecipe
2. getRecipe - http://localhost:8080/api/getRecipe
3. removeRecipe - http://localhost:8080/api/removeRecipe/id
4. updateRecipe - http://localhost:8080/api/updateRecipe/id
5. searchRecipe - http://localhost:8080/api/searchRecipe/true

Development Tools:
1. Java
2. Spring boot
3. Maven
4. Junit

How to create Database
 Step 1: Create the table in Recipe schema using
 > CREATE TABLE `recipe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_on` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `instructions` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `servings` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Step 2: Start the DB server on cmd

> cd C:\Users\jaya.jaiswal\Downloads\mysql-8.0.30-winx64\mysql-8.0.30-winx64\bin
> mysqld --console






