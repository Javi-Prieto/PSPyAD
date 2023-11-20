package com.salesianos.dam.Example_for_Security.Controlador;

import com.salesianos.dam.Example_for_Security.DTO.GETUserDTO;
import com.salesianos.dam.Example_for_Security.DTO.UserDTO;
import com.salesianos.dam.Example_for_Security.Service.UserService;
import com.salesianos.dam.Example_for_Security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<GETUserDTO> createdWithUserRole(@RequestBody UserDTO toSave){
        User newUser = service.createUserWithUserRole(toSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(GETUserDTO.fromUser(newUser));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<GETUserDTO> createdWithAdminRole(@RequestBody UserDTO toSave){
        User newUser = service.createUserWithAdminRole(toSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(GETUserDTO.fromUser(newUser));
    }

}
