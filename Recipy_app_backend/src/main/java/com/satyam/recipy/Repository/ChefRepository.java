package com.satyam.recipy.Repository;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.Recipe;
import com.satyam.recipy.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChefRepository extends MongoRepository<Chef,String> {
    Chef findByChefName(String chefName);

    Chef findByUserName(String username);

}
