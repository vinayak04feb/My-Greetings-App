package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

// Service layer for generating personalized greetings
@Service
public class GreetingService {

    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello " + firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
    }
}