package com.whatsapp.whatsapp_backend.repository;

import com.whatsapp.whatsapp_backend.entity.ChatroomMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatroomMemberRepository extends JpaRepository<ChatroomMember, Long> {
    List<ChatroomMember> findByUserId(Long userId);
}
