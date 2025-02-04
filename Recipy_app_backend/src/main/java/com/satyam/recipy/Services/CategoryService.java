package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.Category;
import com.satyam.recipy.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategoryByName(String name) {
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if (optionalCategory.isPresent()) {
            categoryRepository.delete(optionalCategory.get());
        } else {
            throw new RuntimeException("Category with name " + name + " not found");
        }
    }
    public Category updateCategoryPhotoUrlByName(String name, String newPhotoUrl) {
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setPhotoUrl(newPhotoUrl); // Update the photo URL
            return categoryRepository.save(category); // Save the updated category
        } else {
            throw new RuntimeException("Category with name " + name + " not found");
        }
    }
}