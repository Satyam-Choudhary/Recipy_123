package com.satyam.recipy.Controllers;

import com.satyam.recipy.Entity.*;
import com.satyam.recipy.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return adminService.getAllRecipes();
    }

    @GetMapping("/chefs")
    public List<Chef> getAllChefs() {
        return adminService.getAllChefs();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return adminService.getAllCategories();
    }
    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return adminService.getAllIngredients();
    }

    @PostMapping("/ingredient")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return adminService.addIngredient(ingredient);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        return adminService.addCategory(category);
    }
}
