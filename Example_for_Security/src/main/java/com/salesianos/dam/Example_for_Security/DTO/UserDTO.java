package com.salesianos.dam.Example_for_Security.DTO;

import lombok.Builder;

@Builder
public record UserDTO(
        String username,
        String passw,
        String verifyPasw,
        String avatar,
        String fullName
) {
}
