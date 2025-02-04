package com.satyam.recipy.Services;

import com.satyam.recipy.Entity.AppUserDetails;
import com.satyam.recipy.Entity.Chef;
import com.satyam.recipy.Entity.User;
import com.satyam.recipy.Repository.ChefRepository;
import com.satyam.recipy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUserName(username));
        if (user.isPresent()) {
            return buildUserDetails(user.get());
        }

        Optional<Chef> chef = Optional.ofNullable(chefRepository.findByUserName(username));
        if (chef.isPresent()) {
            return buildUserDetails(chef.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }

    private UserDetails buildUserDetails(AppUserDetails appUser) {
        return new org.springframework.security.core.userdetails.User(
                appUser.getUserName(),
                appUser.getPassword(),
                appUser.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.name()))
                        .collect(Collectors.toList())
        );

    }
}

