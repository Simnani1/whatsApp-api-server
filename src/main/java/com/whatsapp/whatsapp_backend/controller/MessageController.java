package com.whatsapp.whatsapp_backend.controller;

import com.whatsapp.whatsapp_backend.dto.MessageDTO;
import com.whatsapp.whatsapp_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/chatrooms/{chatroomId}/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public MessageDTO sendMessage(
            @PathVariable Long chatroomId,
            @RequestParam Long senderId,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) MultipartFile attachment) {
        return messageService.sendMessage(chatroomId, senderId, text, attachment);
    }

    @GetMapping
    public Page<MessageDTO> getMessages(
            @PathVariable Long chatroomId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return messageService.getMessages(chatroomId, page, size);
    }
}

