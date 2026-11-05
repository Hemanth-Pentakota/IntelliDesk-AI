package com.intellidesk.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "IntelliDesk AI Backend is running!";
    }
}