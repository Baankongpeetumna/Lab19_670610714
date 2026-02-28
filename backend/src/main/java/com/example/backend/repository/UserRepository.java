package com.example.backend.repository;

import com.example.backend.model.UserModel;

import java.util.UUID;

public interface UserRepository {
    UUID addUser(String username);
    UserModel getUserByID(UUID id);
}