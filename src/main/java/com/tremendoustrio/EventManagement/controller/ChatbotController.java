package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatbotController {
    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/chatbot")
    public String interactWithChatbot(@RequestBody String userMessage) {
        return chatbotService.sendMessage(userMessage);
    }
}
