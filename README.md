# AbnAssessment
A standalone java application called "Recipe Central" which allows users to manage their favourite recipes using Java, Spring boot 2.7.2, maven and Junit.

I have a model for Recipe with fields-
Name
Type
Servings
Ingredients
Instructions
Creator
CreatedOn

The controller has methods like-
1. addRecipe
2. getRecipe
3. removeRecipe
4. updateRecipe
5. searchRecipe

The service uses RecipeSpecification to allow multiple searches using JPA Sepcification and predicates which are used by criteria Builder to build the search query.

The database used is MySql and test cases are written using junit and mockito.

The localhost url is - http://localhost:8080/api/getRecipe


