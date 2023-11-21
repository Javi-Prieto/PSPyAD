package com.salesianos.dam.Example_for_Security.Controlador;

import com.salesianos.dam.Example_for_Security.DTO.*;
import com.salesianos.dam.Example_for_Security.Security.jwt.access.JwtProvider;
import com.salesianos.dam.Example_for_Security.Service.UserService;
import com.salesianos.dam.Example_for_Security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/auth/register")
    public ResponseEntity<GETUserDTO> createdWithUserRole(@RequestBody UserDTO toSave){
        User newUser = service.createUserWithUserRole(toSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(GETUserDTO.fromUser(newUser));
    }

    @PostMapping("/auth/register/admin")
    public ResponseEntity<GETUserDTO> createdWithAdminRole(@RequestBody UserDTO toSave){
        User newUser = service.createUserWithAdminRole(toSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(GETUserDTO.fromUser(newUser));
    }
    @PostMapping("/auth/login")
    public ResponseEntity<JwtUserResponse> login(@RequestBody POSTLoginDTO loginRequest) {

        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.username(),
                                loginRequest.password()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        User user = (User) authentication.getPrincipal();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(JwtUserResponse.of(user, token));


    }

    @PutMapping("/user/changePassword")
    public ResponseEntity<GETUserDTO> changePassword(@RequestBody PUTPasswordDTO changePasswordRequest,
                                                       @AuthenticationPrincipal User loggedUser) {
        try {
            if (service.passwordMatch(loggedUser, changePasswordRequest.oldPassword())) {
                Optional<User> modified = service.editPassword(loggedUser.getId(), changePasswordRequest.newPassword());
                if (modified.isPresent())
                    return ResponseEntity.ok(GETUserDTO.fromUser(modified.get()));
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password Data Error");
        }

        return null;
    }

}
