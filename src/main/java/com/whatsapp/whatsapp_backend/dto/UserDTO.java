package com.whatsapp.whatsapp_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String phone;
    private String profilePictureUrl;
    private String status;
}