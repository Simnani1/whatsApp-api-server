package com.whatsapp.whatsapp_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReactionDTO {
    private Long id;
    private Long messageId;
    private Long userId;
    private String emoji;
}

