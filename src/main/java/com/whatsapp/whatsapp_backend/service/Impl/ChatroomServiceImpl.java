package com.whatsapp.whatsapp_backend.service.Impl;

import com.whatsapp.whatsapp_backend.dto.ChatroomDTO;
import com.whatsapp.whatsapp_backend.dto.CreateChatroomRequest;
import com.whatsapp.whatsapp_backend.entity.Chatroom;
import com.whatsapp.whatsapp_backend.entity.ChatroomMember;
import com.whatsapp.whatsapp_backend.repository.ChatroomMemberRepository;
import com.whatsapp.whatsapp_backend.repository.ChatroomRepository;
import com.whatsapp.whatsapp_backend.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    private ChatroomRepository chatroomRepository;

    @Autowired
    private ChatroomMemberRepository chatroomMemberRepository;

    @Override
    public ChatroomDTO createChatroom(CreateChatroomRequest request) {
        Chatroom chatroom = Chatroom.builder()
                .name(request.getName())
                .isGroup(request.getIsGroup())
                .createdBy(request.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .build();

        Chatroom saved = chatroomRepository.save(chatroom);

        // Save members
        for (Long userId : request.getMemberIds()) {
            ChatroomMember member = ChatroomMember.builder()
                    .chatroomId(saved.getId())
                    .userId(userId)
                    .build();
            chatroomMemberRepository.save(member);
        }

        return ChatroomDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .isGroup(saved.getIsGroup())
                .createdBy(saved.getCreatedBy())
                .build();
    }

    @Override
    public Page<ChatroomDTO> getUserChatrooms(Long userId, Pageable pageable) {
        List<ChatroomMember> memberships = chatroomMemberRepository.findByUserId(userId);
        List<Long> chatroomIds = memberships.stream().map(ChatroomMember::getChatroomId).toList();

        List<ChatroomDTO> chatrooms = chatroomRepository.findAllById(chatroomIds)
                .stream()
                .map(chatroom -> ChatroomDTO.builder()
                        .id(chatroom.getId())
                        .name(chatroom.getName())
                        .isGroup(chatroom.getIsGroup())
                        .createdBy(chatroom.getCreatedBy())
                        .build())
                .toList();

        return new PageImpl<>(chatrooms, pageable, chatrooms.size());
    }

    @Override
    public ChatroomDTO getChatroomById(Long chatroomId) {
        Chatroom chatroom = chatroomRepository.findById(chatroomId)
                .orElseThrow(() -> new RuntimeException("Chatroom not found"));

        return ChatroomDTO.builder()
                .id(chatroom.getId())
                .name(chatroom.getName())
                .isGroup(chatroom.getIsGroup())
                .createdBy(chatroom.getCreatedBy())
                .build();
    }
}