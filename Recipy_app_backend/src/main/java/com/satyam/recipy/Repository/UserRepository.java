package com.satyam.recipy.Repository;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName(String username);
    void deleteByUserName(String name);
}
