package com.whatsapp.whatsapp_backend.repository;

import com.whatsapp.whatsapp_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
