package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Entity.YouTubeChannel;
import com.satyam.recipy.Repository.ChefRepository;
import com.satyam.recipy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PublicService {
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private YouTubeService youTubeService;
    public Chef addChef(Chef chef) {
        chef.setUserName(chef.getUserName());
        chef.setPassword(passwordEncoder.encode(chef.getPassword()));
        chef.setYouTubeChannel(youTubeService.getChannelDetailsByHandle(chef.getYtHandle()));
        return chefRepository.save(chef);
    }

    public User addUser(User user) {
        user.setUserName(user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
