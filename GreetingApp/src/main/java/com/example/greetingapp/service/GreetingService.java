package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

// Service layer responsible for greeting messages
@Service
public class GreetingService {

    public String getSimpleGreeting() {
        return "Hello World";
    }
}