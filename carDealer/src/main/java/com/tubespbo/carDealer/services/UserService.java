package com.tubespbo.carDealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.PetugasDealer;
import com.tubespbo.carDealer.models.SalesDealer;
import com.tubespbo.carDealer.models.User;
import com.tubespbo.carDealer.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Save User (General)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Save SalesDealer
    public SalesDealer saveSalesDealer(SalesDealer salesDealer) {
        return (SalesDealer) userRepository.save(salesDealer);
    }

    // Save PetugasDealer
    public PetugasDealer savePetugasDealer(PetugasDealer petugasDealer) {
        return (PetugasDealer) userRepository.save(petugasDealer);
    }

    // Update User
    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setNama(userDetails.getNama());
        user.setNoTelp(userDetails.getNoTelp());
        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
