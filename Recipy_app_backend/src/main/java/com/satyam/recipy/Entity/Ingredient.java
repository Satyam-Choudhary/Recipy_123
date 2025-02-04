package com.satyam.recipy.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredient")
@Data
public class Ingredient {
    @Id
    private String id;
    private String nameInEnglish;
    private String nameInHindi;
    private String unit;
    private boolean veg;
    private boolean jain;
}
