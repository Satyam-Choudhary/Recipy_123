package com.satyam.recipy.Controllers;

import com.satyam.recipy.Entity.Recipe;
import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.YouTubeChannel;
import com.satyam.recipy.Services.ChefService;
import com.satyam.recipy.Services.RecipeService;
import com.satyam.recipy.Services.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chef")
public class ChefController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private ChefService chefService;


    @PutMapping("/password")
    public Chef changePassword(@RequestParam String newPassword) {
        return chefService.changePassword(newPassword);
    }

    @PutMapping("/image")
    public Chef changeImageURL(@RequestParam String imageURL) {
        return chefService.changeImageURL(imageURL);
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return chefService.addRecipe(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable String id) {
        chefService.deleteRecipe(id);
    }

    @GetMapping("/my-recipes")
    public List<Recipe> getMyRecipes() {
        return chefService.getMyRecipes();
    }

    @GetMapping("/recipes")
    public List<Recipe> seeOtherRecipes() {
        return chefService.seeOtherRecipes();
    }

    @PutMapping("/ytHandle")
    public Chef addYTHandle(@RequestParam String ytHandle) {
        return chefService.addYTHandle(ytHandle);
    }

}
