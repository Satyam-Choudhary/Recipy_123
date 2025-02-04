package com.satyam.recipy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chef")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chef implements AppUserDetails{
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private String chefName;
    private String ytHandle;
    private YouTubeChannel youTubeChannel;
    private String imageURL;
    @Override
    public List<Role> getRoles() {
        return List.of(Role.ROLE_CHEF);
    }

}

