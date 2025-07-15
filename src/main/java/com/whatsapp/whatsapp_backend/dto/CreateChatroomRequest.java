package com.whatsapp.whatsapp_backend.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatroomRequest {
    private String name;
    private Boolean isGroup;
    private Long createdBy;
    private List<Long> memberIds;
}
