package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.*;
import com.satyam.recipy.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredientRepository.existsByNameInEnglish(ingredient.getNameInEnglish())) {
            throw new RuntimeException("Ingredient with name '" + ingredient.getNameInEnglish() + "' already exists.");
        }
        return ingredientRepository.save(ingredient);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
