package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.Recipe;
import com.satyam.recipy.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public boolean saveNewRecipe(Recipe recipe) {
        try {
            recipeRepository.save(recipe);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getEntryById(String id) {
        return recipeRepository.findById(id);
    }

    public void deleteEntryById(String id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipeByName(String recipeName) {
        return recipeRepository.findByRecipeName(recipeName);
    }
//    public List<Recipe> getRecipeByChefName(String chefName){
//        Chef chef = chefRepository.findByChefName(chefName);
//        return chef.getListOfRecipes();
//    }
}
