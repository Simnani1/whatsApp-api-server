package com.whatsapp.whatsapp_backend.controller;

import com.whatsapp.whatsapp_backend.dto.ReactionDTO;
import com.whatsapp.whatsapp_backend.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages/{messageId}/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping
    public ReactionDTO reactToMessage(
            @PathVariable Long messageId,
            @RequestParam Long userId,
            @RequestParam String emoji) {
        return reactionService.reactToMessage(messageId, userId, emoji);
    }

    @GetMapping
    public List<ReactionDTO> getReactions(@PathVariable Long messageId) {
        return reactionService.getReactionsForMessage(messageId);
    }
}

