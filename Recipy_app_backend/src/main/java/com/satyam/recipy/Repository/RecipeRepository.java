package com.satyam.recipy.Repository;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe,String> {

    List<Recipe> findByRecipeName(String recipeName);

    List<Recipe> findByChef(Chef chef);

    List<Recipe> findByChefNot(Chef chef);
}
