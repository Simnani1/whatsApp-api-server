package com.whatsapp.whatsapp_backend.service;

import com.whatsapp.whatsapp_backend.dto.ChatroomDTO;
import com.whatsapp.whatsapp_backend.dto.CreateChatroomRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatroomService {
    ChatroomDTO createChatroom(CreateChatroomRequest request);
    Page<ChatroomDTO> getUserChatrooms(Long userId, Pageable pageable);
    ChatroomDTO getChatroomById(Long chatroomId);
}

