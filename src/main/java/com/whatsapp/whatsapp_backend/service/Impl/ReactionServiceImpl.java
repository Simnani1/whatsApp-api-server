package com.whatsapp.whatsapp_backend.service.Impl;

import com.whatsapp.whatsapp_backend.dto.ReactionDTO;
import com.whatsapp.whatsapp_backend.entity.Reaction;
import com.whatsapp.whatsapp_backend.repository.ReactionRepository;
import com.whatsapp.whatsapp_backend.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionServiceImpl implements ReactionService {

    private static final List<String> ALLOWED_EMOJIS = Arrays.asList("thumbup", "love", "crying", "surprised");

    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public ReactionDTO reactToMessage(Long messageId, Long userId, String emoji) {
        if (!ALLOWED_EMOJIS.contains(emoji)) {
            throw new IllegalArgumentException("Emoji must be one of: " + ALLOWED_EMOJIS);
        }

        Reaction reaction = Reaction.builder()
                .messageId(messageId)
                .userId(userId)
                .emoji(emoji)
                .build();

        reaction = reactionRepository.save(reaction);

        return ReactionDTO.builder()
                .id(reaction.getId())
                .messageId(reaction.getMessageId())
                .userId(reaction.getUserId())
                .emoji(reaction.getEmoji())
                .build();
    }

    @Override
    public List<ReactionDTO> getReactionsForMessage(Long messageId) {
        return reactionRepository.findByMessageId(messageId).stream()
                .map(r -> ReactionDTO.builder()
                        .id(r.getId())
                        .messageId(r.getMessageId())
                        .userId(r.getUserId())
                        .emoji(r.getEmoji())
                        .build())
                .collect(Collectors.toList());
    }
}

