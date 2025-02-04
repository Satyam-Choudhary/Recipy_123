//package com.satyam.recipy.Services;
//
//import com.satyam.recipy.Entity.Chef;
//import com.satyam.recipy.Entity.User;
//import com.satyam.recipy.Repository.ChefRepository;
//import com.satyam.recipy.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ChefDetailsServiceImpl  implements UserDetailsService {
//
//    @Autowired
//    private ChefRepository chefRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Chef chef = chefRepository.findByUserName(username);
//        if(chef!=null){
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(chef.getUserName())
//                    .password(chef.getPassword())
//                    .build();
//        }
//        throw new UsernameNotFoundException("User not found with this exception"+username);
//    }
//}
