package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateMessage {
    private UUID userID;
    private String message;
}