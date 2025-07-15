package com.whatsapp.whatsapp_backend.repository;

import com.whatsapp.whatsapp_backend.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    List<Reaction> findByMessageId(Long messageId);
}

