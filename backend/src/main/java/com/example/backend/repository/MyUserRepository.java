package com.example.backend.repository;

import com.example.backend.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MyUserRepository implements UserRepository {

    private final Map<UUID, UserModel> users = new HashMap<>();

    @Override
    public UUID addUser(String username) {
        UUID id = UUID.randomUUID();
        users.put(id, new UserModel(id, username));
        return id;
    }

    @Override
    public UserModel getUserByID(UUID id) {
        return users.get(id);
    }
}