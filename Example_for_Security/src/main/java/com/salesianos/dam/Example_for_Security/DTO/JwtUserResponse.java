package com.salesianos.dam.Example_for_Security.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianos.dam.Example_for_Security.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtUserResponse {
    private String id;
    private String username, avatar, fullName;
    private String token;
    private String refreshToken;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime createdAt;

    public JwtUserResponse(GETUserDTO userResponse) {
        id = userResponse.id();
        username = userResponse.username();
        fullName = userResponse.fullName();
        avatar = userResponse.avatar();
        createdAt = userResponse.createdAt();
    }

    public static JwtUserResponse of (User user, String token) {
        JwtUserResponse result = new JwtUserResponse(GETUserDTO.fromUser(user));
        result.setToken(token);
        return result;

    }
}
