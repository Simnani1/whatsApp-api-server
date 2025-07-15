package com.whatsapp.whatsapp_backend.repository;

import com.whatsapp.whatsapp_backend.entity.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
}
