package com.satyam.recipy.Repository;

import com.satyam.recipy.Entity.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    boolean existsByNameInEnglish(String nameInEnglish);
    Optional<Ingredient> findByNameInEnglish(String nameInEnglish);
}