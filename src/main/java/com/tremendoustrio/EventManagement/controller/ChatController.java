//package com.tremendoustrio.EventManagement.controller;
//
//import com.tremendoustrio.EventManagement.service.DialogflowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/chat")
//public class ChatController {
//    @Autowired
//    private DialogflowService dialogflowService;
//
//    @PostMapping("/bot")
//    public ResponseEntity<?> chat(@RequestBody Map<String, String> request) {
//        String sessionId = request.get("sessionId");
//        String message = request.get("message");
//
//        if (sessionId == null || sessionId.isEmpty()) {
//            return ResponseEntity.badRequest().body("Session ID is missing or empty");
//        }
//        if (message == null || message.isEmpty()) {
//            return ResponseEntity.badRequest().body("Message is missing or empty");
//        }
//
//        String fulfillmentText = dialogflowService.detectIntent(sessionId, message);
//        return ResponseEntity.ok(Map.of("response", fulfillmentText));
//    }
//}
