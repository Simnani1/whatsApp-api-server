package com.whatsapp.whatsapp_backend.repository;

import com.whatsapp.whatsapp_backend.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatroomId(Long chatroomId, Pageable pageable);
}
