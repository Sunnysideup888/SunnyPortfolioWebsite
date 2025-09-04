package com.sunnyportfoliowebsite.backend.controller;

import com.sunnyportfoliowebsite.backend.model.User;
import com.sunnyportfoliowebsite.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/test")
    public String test() {
        return "Backend works just fine and this is awesome and so cool help me";
    }

    @GetMapping("/api/helloWorld")
    public String helloWorld() {
        return "Hello World from the backend";
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userRepository
                .findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
