package com.whatsapp.whatsapp_backend.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDTO {
    private Long id;
    private Long chatroomId;
    private Long senderId;
    private String text;
    private String attachmentUrl;
    private String type;
    private LocalDateTime sentAt;
}

