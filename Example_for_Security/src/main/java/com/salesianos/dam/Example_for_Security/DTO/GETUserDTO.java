package com.salesianos.dam.Example_for_Security.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianos.dam.Example_for_Security.model.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GETUserDTO(
        String id,
        String username,
        String avatar,
        String fullName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt
) {
    public static GETUserDTO fromUser(User u){
        return GETUserDTO.builder()
                .id(u.getId().toString())
                .username(u.getUsername())
                .avatar(u.getAvatar())
                .fullName(u.getFullName())
                .build();
    }
}
