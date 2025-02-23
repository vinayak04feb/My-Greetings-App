package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        String message = greetingService.getPersonalizedGreeting(firstName, lastName);
        return ResponseEntity.ok("{\"message\": \"" + message + "\"}");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        return greeting.map(value -> ResponseEntity.ok("{\"id\": " + value.getId() + ", \"message\": \"" + value.getMessage() + "\"}"))
                .orElseGet(() -> ResponseEntity.status(404).body("{\"error\": \"Greeting not found\"}"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

    // PUT method to update a greeting by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, newMessage);
        return updatedGreeting.map(value -> ResponseEntity.ok("{\"id\": " + value.getId() + ", \"message\": \"" + value.getMessage() + "\"}"))
                .orElseGet(() -> ResponseEntity.status(404).body("{\"error\": \"Greeting not found or could not be updated\"}"));
    }
}