package com.satyam.recipy.Repository;

import com.satyam.recipy.Entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<Category> findByName(String name); // Custom query method to find by name

}
