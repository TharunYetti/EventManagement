package com.tremendoustrio.EventManagement.service;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatbotService {

    Dotenv dotenv = Dotenv.load();
    private String apiKey = dotenv.get("CHATBOT_API_TOKEN");

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendMessage(String userMessage) {
        String apiUrl = dotenv.get("CHATBOT_API_URL");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String body = "{ \"message\": \"" + userMessage + "\" }";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            return response.getBody();
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return "An error occurred while communicating with the chatbot service.";
        }
    }
}
