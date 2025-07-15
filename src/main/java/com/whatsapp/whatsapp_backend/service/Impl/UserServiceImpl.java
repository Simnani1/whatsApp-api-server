package com.whatsapp.whatsapp_backend.service.Impl;


import com.whatsapp.whatsapp_backend.dto.UserDTO;
import com.whatsapp.whatsapp_backend.entity.User;
import com.whatsapp.whatsapp_backend.repository.UserRepository;
import com.whatsapp.whatsapp_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .profilePictureUrl(user.getProfilePictureUrl())
                .status(user.getStatus())
                .build();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .profilePictureUrl(userDTO.getProfilePictureUrl())
                .status(userDTO.getStatus())
                .build();

        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    private void updateUserEntity(User user, UserDTO dto) {
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setProfilePictureUrl(dto.getProfilePictureUrl());
        user.setStatus(dto.getStatus());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return convertToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        updateUserEntity(user, userDTO);
        User updated = userRepository.save(user);
        return convertToDTO(updated);
    }
}
