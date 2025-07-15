package com.whatsapp.whatsapp_backend.service;

import com.whatsapp.whatsapp_backend.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface MessageService {
    MessageDTO sendMessage(Long chatroomId, Long senderId, String text, MultipartFile attachment);
    Page<MessageDTO> getMessages(Long chatroomId, int page, int size);
}

