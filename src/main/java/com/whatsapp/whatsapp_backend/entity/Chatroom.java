package com.whatsapp.whatsapp_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chatrooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chatroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isGroup;

    private Long createdBy;

    private LocalDateTime createdAt;
}

