package com.whatsapp.whatsapp_backend.service;

import com.whatsapp.whatsapp_backend.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO createUser(UserDTO userDTO);
}
