package com.whatsapp.whatsapp_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatroomDTO {
    private Long id;
    private String name;
    private Boolean isGroup;
    private Long createdBy;
}
