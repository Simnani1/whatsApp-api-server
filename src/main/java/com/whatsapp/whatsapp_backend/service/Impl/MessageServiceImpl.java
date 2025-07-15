package com.whatsapp.whatsapp_backend.service.Impl;

import com.whatsapp.whatsapp_backend.dto.MessageDTO;
import com.whatsapp.whatsapp_backend.entity.Message;
import com.whatsapp.whatsapp_backend.repository.MessageRepository;
import com.whatsapp.whatsapp_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    private final String ROOT = "root";

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MessageDTO sendMessage(Long chatroomId, Long senderId, String text, MultipartFile attachment) {
        String type = "text";
        String attachmentUrl = null;

        if (attachment != null && !attachment.isEmpty()) {
            String originalName = attachment.getOriginalFilename();
            String extension = originalName.substring(originalName.lastIndexOf('.') + 1).toLowerCase();
            String uniqueName = UUID.randomUUID() + "." + extension;

            if (attachment.getSize() > 10 * 1024 * 1024) {
                throw new RuntimeException("File size must be under 10MB");
            }

            if (extension.matches("jpg|jpeg|png|gif")) {
                type = "image";
                saveFile(attachment, ROOT + "/picture/" + uniqueName);
                attachmentUrl = "/picture/" + uniqueName;
            } else if (extension.matches("mp4|avi|mov|mkv")) {
                type = "video";
                saveFile(attachment, ROOT + "/video/" + uniqueName);
                attachmentUrl = "/video/" + uniqueName;
            } else {
                throw new RuntimeException("Unsupported file type");
            }
        }

        Message message = Message.builder()
                .chatroomId(chatroomId)
                .senderId(senderId)
                .text(text)
                .attachmentUrl(attachmentUrl)
                .type(type)
                .sentAt(LocalDateTime.now())
                .build();

        message = messageRepository.save(message);

        return convertToDTO(message);
    }

    private void saveFile(MultipartFile file, String path) {
        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

    @Override
    public Page<MessageDTO> getMessages(Long chatroomId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("sentAt").descending());
        Page<Message> messages = messageRepository.findByChatroomId(chatroomId, pageable);

        return messages.map(this::convertToDTO);
    }

    private MessageDTO convertToDTO(Message m) {
        return MessageDTO.builder()
                .id(m.getId())
                .chatroomId(m.getChatroomId())
                .senderId(m.getSenderId())
                .text(m.getText())
                .attachmentUrl(m.getAttachmentUrl())
                .type(m.getType())
                .sentAt(m.getSentAt())
                .build();
    }
}

