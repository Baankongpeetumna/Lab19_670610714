package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class MessageModel {

    private UUID messageID;   // ⭐ ต้องชื่อ messageID
    private UserModel user;   // ⭐ ต้องเป็น object
    private String message;
    private boolean deleted;  // ⭐ ต้องมี
}