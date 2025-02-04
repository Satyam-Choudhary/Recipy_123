package com.satyam.recipy.Controllers;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Entity.Recipe;
import com.satyam.recipy.Repository.UserRepository;
import com.satyam.recipy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PutMapping("/password")
    public User changePassword(@RequestParam String newPassword) {
        return userService.changePassword(newPassword);
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return userService.getAllRecipes();
    }

    @PostMapping("/recipe/rate")
    public Recipe rateRecipe(@RequestParam String recipeId, @RequestParam int rating) {
        return userService.rateRecipe(recipeId, rating);
    }

    @PutMapping("/photo")
    public User changePhoto(@RequestParam String imageURL) {
        return userService.changePhoto(imageURL);
    }

    @PostMapping("/favourites")
    public User addRecipeToFavourites(@RequestParam String recipeId) {
        return userService.addRecipeToFavourites(recipeId);
    }
}
