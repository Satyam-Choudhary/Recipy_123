package com.satyam.recipy.Services;


import com.satyam.recipy.Entity.Ingredient;
import com.satyam.recipy.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Add a new ingredient
    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredientRepository.existsByNameInEnglish(ingredient.getNameInEnglish())) {
            throw new RuntimeException("Ingredient with name '" + ingredient.getNameInEnglish() + "' already exists.");
        }
        return ingredientRepository.save(ingredient);
    }

    // Get all ingredients
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Delete an ingredient by name
    public void deleteIngredientByNameInEnglish(String nameInEnglish) {
        Optional<Ingredient> ingredient = ingredientRepository.findByNameInEnglish(nameInEnglish);
        if (ingredient.isPresent()) {
            ingredientRepository.delete(ingredient.get());
        } else {
            throw new RuntimeException("Ingredient not found with name: " + nameInEnglish);
        }
    }
}
