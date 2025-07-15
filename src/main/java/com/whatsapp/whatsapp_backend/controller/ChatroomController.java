package com.whatsapp.whatsapp_backend.controller;

import com.whatsapp.whatsapp_backend.dto.ChatroomDTO;
import com.whatsapp.whatsapp_backend.dto.CreateChatroomRequest;
import com.whatsapp.whatsapp_backend.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatroomController {

    @Autowired
    private ChatroomService chatroomService;

    @PostMapping
    public ChatroomDTO createChatroom(@RequestBody CreateChatroomRequest request) {
        return chatroomService.createChatroom(request);
    }

    @GetMapping
    public Page<ChatroomDTO> getUserChatrooms(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chatroomService.getUserChatrooms(userId, pageable);
    }

    @GetMapping("/{id}")
    public ChatroomDTO getChatroom(@PathVariable Long id) {
        return chatroomService.getChatroomById(id);
    }
}