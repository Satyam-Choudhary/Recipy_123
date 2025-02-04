package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.Recipe;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Repository.ChefRepository;
import com.satyam.recipy.Repository.RecipeRepository;
import com.satyam.recipy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    public Chef changePassword(String newPassword) {
        Chef chef = getAuthenticatedChef();
        chef.setPassword(newPassword);
        return chefRepository.save(chef);
    }

    public Chef changeImageURL(String imageURL) {
        Chef chef = getAuthenticatedChef();
        chef.setImageURL(imageURL);
        return chefRepository.save(chef);
    }

    public Recipe addRecipe(Recipe recipe) {
        recipe.setChef(getAuthenticatedChef());
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(String id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        recipeRepository.delete(recipe);
    }

    public List<Recipe> getMyRecipes() {
        Chef chef = getAuthenticatedChef();
        return recipeRepository.findByChef(chef);
    }

    public List<Recipe> seeOtherRecipes() {
        Chef chef = getAuthenticatedChef();
        return recipeRepository.findByChefNot(chef);
    }

    public Chef addYTHandle(String ytHandle) {
        Chef chef = getAuthenticatedChef();
        chef.setYtHandle(ytHandle);
        return chefRepository.save(chef);
    }

    private Chef getAuthenticatedChef() {
        // Fetch the currently authenticated chef from the SecurityContext
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        try{
            return chefRepository.findByUserName(username);
        }
        catch(Exception e){
            throw new RuntimeException("Chef not found");
        }
    }
}
