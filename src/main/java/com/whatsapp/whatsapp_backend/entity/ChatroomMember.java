package com.whatsapp.whatsapp_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chatroom_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatroomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatroomId;

    private Long userId;
}

