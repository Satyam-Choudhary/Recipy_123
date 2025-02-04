package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.Rating;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Repository.RecipeRepository;
import com.satyam.recipy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.satyam.recipy.Entity.Recipe;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User changePassword(String newPassword) {
        User user = getAuthenticatedUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe rateRecipe(String recipeId, int rating) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        User user = getAuthenticatedUser();
        recipe.getListOfRating().add(new Rating(user, rating));
        return recipeRepository.save(recipe);
    }

    public User changePhoto(String imageURL) {
        User user = getAuthenticatedUser();
        user.setImageURL(imageURL);
        return userRepository.save(user);
    }

    public User addRecipeToFavourites(String recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        User user = getAuthenticatedUser();
        user.getFavourites().add(recipe);
        return userRepository.save(user);
    }

    private User getAuthenticatedUser() {
        // Fetch the currently authenticated user from the SecurityContext
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        try{
            return userRepository.findByUserName(username);
        }
        catch(Exception e){
            throw new RuntimeException("User not found");
        }
    }
}
