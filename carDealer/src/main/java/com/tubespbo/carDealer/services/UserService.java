package com.tubespbo.carDealer.services;

import com.tubespbo.carDealer.models.User;

public interface UserService {
    User login(String username, String password);
}