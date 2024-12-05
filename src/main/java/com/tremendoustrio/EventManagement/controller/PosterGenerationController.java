package com.tremendoustrio.EventManagement.controller;

import com.tremendoustrio.EventManagement.service.PosterGenerationService;
import com.tremendoustrio.EventManagement.service.VolunteerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PosterGenerationController {
    @Autowired
    private PosterGenerationService posterGenerationService;
    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/generate-poster")
    public ResponseEntity<Map<String, String>> generatePoster(@RequestBody Map<String, String> request) {
        String description = request.get("description");
        String imageUrl = posterGenerationService.generateImage(description);
        Map<String, String> response = new HashMap<>();
        response.put("outputUrl", imageUrl);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/volunteerStatus")
    public ResponseEntity<Map<String, Boolean>> checkCondition(HttpSession session) {
        boolean result = volunteerService.check(session); // Your logic here

        // Creating a map to hold the result
        Map<String, Boolean> response = new HashMap<>();
        response.put("result", result);

        // Returning the response as JSON
        return ResponseEntity.ok(response);
    }

}
