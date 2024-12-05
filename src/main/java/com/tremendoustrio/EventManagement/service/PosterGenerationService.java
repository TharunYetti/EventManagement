package com.tremendoustrio.EventManagement.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PosterGenerationService {

    Dotenv dotenv = Dotenv.load();
    private final String apiUrl = dotenv.get("POSTER_API_URL");
    private final String apiKey = dotenv.get("POSTER_API_TOKEN");

    public String generateImage(String description) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(description, headers);

        try {
            // Call the API and get the response as a byte array
            ResponseEntity<byte[]> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, byte[].class);

            // Convert byte array to a base64 encoded string (if needed)
            byte[] imageBytes = response.getBody();
            String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);

            // Return the base64 string for display
            return "data:image/jpeg;base64," + base64Image;
        } catch (HttpClientErrorException e) {
            System.err.println("Error Status Code: " + e.getStatusCode());
            System.err.println("Error Response Body: " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            throw e;
        }
    }
}
