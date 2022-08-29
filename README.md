# Recipe Central
A standalone java application called "Recipe Central" which allows users to manage their favourite recipes using Java, Spring boot, maven and Junit. The service uses RecipeSpecification to allow multiple searches using JPA Sepcification and predicates which are used by criteria Builder to build the search query. The database used is MySql and test cases are written using junit and mockito.

Recipe class with fields-  <br/>
•	Name <br/>
•	Type <br/>
•	Servings  <br/>
•	Ingredients  <br/>
•	Instructions  <br/>
•	Creator  <br/>
•	CreatedOn  <br/>


# Features

•	addRecipe - http://localhost:8080/api/addRecipe  <br/>
•	getRecipe - http://localhost:8080/api/getRecipe  <br/>
•	removeRecipe - http://localhost:8080/api/removeRecipe/id  <br/>
•	updateRecipe - http://localhost:8080/api/updateRecipe/id  <br/>
•	searchRecipe - http://localhost:8080/api/searchRecipe/true  <br/>


# Development Tools:
1. Java
2. Spring boot
3. Maven
4. Junit
5. MySql

# How to create Database 

1. Create the table in Recipe schema using

> CREATE TABLE recipe ( id bigint NOT NULL AUTO_INCREMENT, created_on datetime DEFAULT NULL, creator varchar(255) DEFAULT NULL, ingredients varchar(255) DEFAULT NULL, instructions varchar(255) DEFAULT NULL, name varchar(255) DEFAULT NULL, servings int DEFAULT NULL, type varchar(255) DEFAULT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

2. Start the DB server on cmd

> cd C:\Users\jaya.jaiswal\Downloads\mysql-8.0.30-winx64\mysql-8.0.30-winx64\bin 
> mysqld --console
