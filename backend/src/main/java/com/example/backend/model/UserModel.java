package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    private UUID userID;   // ⭐ ต้องชื่อ userID
    private String username;
}