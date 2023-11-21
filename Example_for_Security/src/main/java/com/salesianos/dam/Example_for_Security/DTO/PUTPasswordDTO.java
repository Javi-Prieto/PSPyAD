package com.salesianos.dam.Example_for_Security.DTO;

import lombok.Builder;

@Builder
public record PUTPasswordDTO(
        String oldPassword,
        String newPassword,
        String verifyNewPassword
) {
}
