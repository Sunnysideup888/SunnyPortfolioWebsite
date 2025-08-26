package com.sunnyportfoliowebsite.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/api/test")
    public String test() {
        return "Backend works just fine and this is awesome";
    }
}
