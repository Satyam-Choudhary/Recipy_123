package com.satyam.recipy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YouTubeChannel {
    private String title;          // Channel name
    private String description;    // Channel description
    private long subscriberCount;  // Total subscribers
}
