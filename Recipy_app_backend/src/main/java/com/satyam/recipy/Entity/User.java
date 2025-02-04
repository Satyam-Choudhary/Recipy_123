package com.satyam.recipy.Entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
public class User implements AppUserDetails{
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private String name;
    private String imageURL;
    private List<Recipe> favourites = new ArrayList<>();
    @Override
    public List<Role> getRoles() {
        if(userName.equals("Satyam"))
        {
            return List.of(Role.ROLE_ADMIN);
        }

        return List.of(Role.ROLE_USER);
    }
}
