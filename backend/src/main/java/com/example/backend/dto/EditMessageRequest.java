package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EditMessageRequest {
    private UUID messageID;
    private UUID userID;
    private String newMessage;
}