package com.hari.policytracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping(value = "/")
    public String greet()
    {
        return "Hello World";
    }
    
}
