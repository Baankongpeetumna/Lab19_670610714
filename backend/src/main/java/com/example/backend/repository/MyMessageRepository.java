package com.example.backend.repository;

import com.example.backend.model.MessageModel;
import com.example.backend.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MyMessageRepository implements MessageRepository {

    private final UserRepository userRepository;
    private final List<MessageModel> messages = new ArrayList<>();

    @Override
    public List<MessageModel> getMessage() {
        return messages;
    }

    @Override
    public boolean sendMessage(UUID userID, String message) {

        UserModel user = userRepository.getUserByID(userID);
        if (user == null) return false;

        messages.add(
                new MessageModel(
                        UUID.randomUUID(),  // messageID
                        user,
                        message,
                        false               // deleted
                )
        );

        return true;
    }

    @Override
    public boolean deleteMessage(UUID userID, UUID messageID) {

        for (MessageModel m : messages) {
            if (m.getMessageID().equals(messageID)
                    && m.getUser().getUserID().equals(userID)) {

                m.setDeleted(true); // ⭐ soft delete
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean editMessage(UUID messageID, UUID userID, String newMessage) {

        for (MessageModel m : messages) {
            if (m.getMessageID().equals(messageID)
                    && m.getUser().getUserID().equals(userID)) {

                m.setMessage(newMessage);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<MessageModel> searchMessage(String filter) {

        return messages.stream()
                .filter(m ->
                        m.getMessage().toLowerCase()
                                .contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }
}