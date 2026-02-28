package com.example.backend.repository;

import com.example.backend.model.MessageModel;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {
    List<MessageModel> getMessage();
    boolean sendMessage(UUID userID, String message);
    boolean deleteMessage(UUID userID, UUID messageID);
    boolean editMessage(UUID messageID, UUID userID, String newMessage);
    List<MessageModel> searchMessage(String filter);
}