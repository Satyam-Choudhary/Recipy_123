package com.satyam.recipy.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.satyam.recipy.Entity.YouTubeChannel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YouTubeService {

    private final String API_KEY = "AIzaSyACBJfyVaAFTJEcWz6wqi7iWqDh3Q41c1M"; // Replace with your API Key
    private final String SEARCH_URL = "https://www.googleapis.com/youtube/v3/search";
    private final String CHANNEL_URL = "https://www.googleapis.com/youtube/v3/channels";

    public YouTubeChannel getChannelDetailsByHandle(String handle) {
        // Step 1: Search for the channel using the handle
        String searchUrl = String.format("%s?part=snippet&type=channel&q=%s&key=%s", SEARCH_URL, handle, API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        JsonNode searchResponse = restTemplate.getForObject(searchUrl, JsonNode.class);

        if (searchResponse != null && searchResponse.has("items") && searchResponse.get("items").size() > 0) {
            String channelId = searchResponse.get("items").get(0).get("id").get("channelId").asText();

            // Step 2: Use the channelId to get full details
            String channelUrl = String.format("%s?part=snippet,statistics&id=%s&key=%s", CHANNEL_URL, channelId, API_KEY);
            JsonNode channelResponse = restTemplate.getForObject(channelUrl, JsonNode.class);

            if (channelResponse != null && channelResponse.has("items") && channelResponse.get("items").size() > 0) {
                JsonNode channel = channelResponse.get("items").get(0);
                String title = channel.get("snippet").get("title").asText();
                String description = channel.get("snippet").get("description").asText();
                long subscriberCount = channel.get("statistics").get("subscriberCount").asLong();

                return new YouTubeChannel(title, description, subscriberCount);
            }
        }
        throw new RuntimeException("Channel not found for handle: " + handle);
    }
}