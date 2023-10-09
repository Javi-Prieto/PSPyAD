package com.salesianostriana.dam.rest.dto.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.rest.dto.dto.EditRutaDto;
import com.salesianostriana.dam.rest.dto.dto.GetRutaDto;
import com.salesianostriana.dam.rest.dto.model.entities.Ruta;
import com.salesianostriana.dam.rest.dto.model.repos.RutaRepository;
import com.salesianostriana.dam.rest.dto.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.salesianostriana.dam.rest.dto.model.views.RutaView.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {

    private final RutaRepository rutaRepository;

    private final RutaService rutaService;

    @GetMapping("/")
    @JsonView(RutaList.class)
    public ResponseEntity<List<Ruta>> todas() {

        List<Ruta> rutas = rutaRepository.findAll();

        if (rutas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rutas);

    }

    @PostMapping("/")
    public ResponseEntity<GetRutaDto> nuevaRuta(
            @RequestBody EditRutaDto nuevo) {

            Ruta ruta = rutaService.save(nuevo);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(GetRutaDto.of(ruta));

    }

}
