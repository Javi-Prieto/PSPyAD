package com.salesianostriana.dam.HolaDocker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping("/")
    public ResponseEntity<String> holaMundo(){
        return ResponseEntity.ok("hola mundo de docker");
    }
}
