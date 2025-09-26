package com.example.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JardinController {
    @GetMapping(value="/jardin")
    public String showPrincipal(){
        return "principal";
    }
}
