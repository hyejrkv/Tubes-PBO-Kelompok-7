package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tubespbo.carDealer.models.PetugasDealer;
import com.tubespbo.carDealer.models.SalesDealer;
import com.tubespbo.carDealer.models.User;
import com.tubespbo.carDealer.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Create new SalesDealer
    @PostMapping("/sales")
    public SalesDealer createSalesDealer(@RequestBody SalesDealer salesDealer) {
        return userService.saveSalesDealer(salesDealer);
    }

    // Create new PetugasDealer
    @PostMapping("/petugas")
    public PetugasDealer createPetugasDealer(@RequestBody PetugasDealer petugasDealer) {
        return userService.savePetugasDealer(petugasDealer);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
