package com.satyam.recipy.Entity;

import lombok.Data;

@Data
public class RecipeIngredient {
    private Ingredient ingredient;
    private double quantity; // Allow fractional quantities
}
