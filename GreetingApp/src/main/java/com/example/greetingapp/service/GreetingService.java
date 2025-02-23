package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getPersonalizedGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello " + firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }

        // Save the message in the repository
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);

        return message;
    }

    // Find greeting message by ID
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // List all greeting messages
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}