package com.whatsapp.whatsapp_backend.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatroomId;

    private Long senderId;

    private String text;

    private String attachmentUrl;

    private String type; // "text", "image", "video"

    private LocalDateTime sentAt;
}
