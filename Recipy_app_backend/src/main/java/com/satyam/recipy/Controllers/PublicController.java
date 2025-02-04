package com.satyam.recipy.Controllers;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Services.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
class PublicController {
    @Autowired
    private PublicService publicService;

    @PostMapping("/chef")
    public Chef addChef(@RequestBody Chef chef) {
        return publicService.addChef(chef);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return publicService.addUser(user);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "API is running";
    }

}
