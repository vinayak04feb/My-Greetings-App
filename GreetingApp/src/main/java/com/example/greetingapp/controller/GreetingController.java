package com.example.greetingapp.controller;

import com.example.greetingapp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET method with optional query parameters
    @GetMapping
    public ResponseEntity<String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        String message = greetingService.getPersonalizedGreeting(firstName, lastName);
        return ResponseEntity.ok("{\"message\": \"" + message + "\"}");
    }
}