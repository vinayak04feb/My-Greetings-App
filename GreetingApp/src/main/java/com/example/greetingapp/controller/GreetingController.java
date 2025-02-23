package com.example.greetingapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET method
    @GetMapping
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("{\"message\": \"Hello, this is a GET request\"}");
    }

    // POST method
    @PostMapping
    public ResponseEntity<String> postGreeting() {
        return ResponseEntity.ok("{\"message\": \"Hello, this is a POST request\"}");
    }

    // PUT method
    @PutMapping
    public ResponseEntity<String> putGreeting() {
        return ResponseEntity.ok("{\"message\": \"Hello, this is a PUT request\"}");
    }

    // DELETE method
    @DeleteMapping
    public ResponseEntity<String> deleteGreeting() {
        return ResponseEntity.ok("{\"message\": \"Hello, this is a DELETE request\"}");
    }
}
