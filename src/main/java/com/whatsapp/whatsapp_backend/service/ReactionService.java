package com.whatsapp.whatsapp_backend.service;

import com.whatsapp.whatsapp_backend.dto.ReactionDTO;
import java.util.List;

public interface ReactionService {
    ReactionDTO reactToMessage(Long messageId, Long userId, String emoji);
    List<ReactionDTO> getReactionsForMessage(Long messageId);
}

