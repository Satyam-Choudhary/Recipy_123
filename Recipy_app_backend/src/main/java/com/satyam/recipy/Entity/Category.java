package com.satyam.recipy.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "categories") // Maps this class to a MongoDB collection named "categories"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id; // MongoDB's unique identifier (usually a String)

    private String name; // Name of the category (e.g., "Desserts", "Beverages")

    private String photoUrl; // URL for the category's photo
}
