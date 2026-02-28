package com.example.backend.controller;

import com.example.backend.dto.CreateMessage;
import com.example.backend.dto.EditMessageRequest;
import com.example.backend.model.MessageModel;
import com.example.backend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {

    private final MessageRepository messageRepository;

    @GetMapping
    public List<MessageModel> getAll(){
        return messageRepository.getMessage();
    }

    @PostMapping("/send")
    public boolean send(@RequestBody CreateMessage request){
        return messageRepository.sendMessage(
                request.getUserID(),
                request.getMessage()
        );
    }

    @DeleteMapping("/{userID}/{messageID}")
    public boolean delete(
            @PathVariable UUID userID,
            @PathVariable UUID messageID){
        return messageRepository.deleteMessage(userID, messageID);
    }

    @PutMapping("/edit")
    public boolean edit(@RequestBody EditMessageRequest request){
        return messageRepository.editMessage(
                request.getMessageID(),
                request.getUserID(),
                request.getNewMessage()
        );
    }

    @GetMapping("/search")
    public List<MessageModel> search(@RequestParam String filter){
        return messageRepository.searchMessage(filter);
    }
}