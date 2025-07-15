package com.whatsapp.whatsapp_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long messageId;

    private Long userId;

    private String emoji; // ENUM: thumbup, love, crying, surprised
}
