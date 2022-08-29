package com.recipes.RecipeCentral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.recipes.RecipeCentral.model.Recipe;


@SpringBootTest(classes = RecipeCentralApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeCentralIntegrationTest 
{
@LocalServerPort
private int port;

@Autowired
private TestRestTemplate restTemplate;

@Sql({ "schema.sql", "data.sql" })
@Test
public void testAllRecipes() 
{
assertTrue(
    this.restTemplate
      .getForObject("http://localhost:" + port + "/getRecipes", Recipe.class)
      .getName() != null);
}

@Test
public void testAddEmployee() {
Recipe recipe = new Recipe("Oatmeal", "vegeterian",2, "oats,milk,coconut","boil,pan","Jaya",new Date(2022,3,31));
ResponseEntity<String> responseEntity = this.restTemplate
  .postForEntity("http://localhost:" + port + "/addRecipe", recipe, String.class);
assertEquals(201, responseEntity.getStatusCodeValue());
}
}


