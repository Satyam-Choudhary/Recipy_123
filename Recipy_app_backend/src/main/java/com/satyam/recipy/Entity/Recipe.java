package com.satyam.recipy.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection="recipe")
@Data
public class Recipe {
    @Id
    private String id;
    @NonNull
    @Indexed
    private String recipeName;
    private int duration;
    private List<RecipeIngredient> ingredients;
    private String instructions;
    private String imageURL;
    private String ytLink;
    private boolean isVeg ;
    private boolean isJain;
    private Category category;
    @NonNull
    private Chef chef;
    private LocalDateTime date = LocalDateTime.now();;
    private List<Rating> listOfRating;
    public boolean getIsVeg(){
        for(RecipeIngredient r : ingredients){
            if(!r.getIngredient().isVeg()) return false;
        }
        return true;
    }
    public boolean getIsJain(){
        for(RecipeIngredient r : ingredients){
            if(!r.getIngredient().isJain()) return false;
        }
        return true;
    }
}
