package com.salesianostriana.dam.rest.dto.controller;

import com.salesianostriana.dam.rest.dto.dto.GetMonumentoDto;
import com.salesianostriana.dam.rest.dto.model.Monumento;
import com.salesianostriana.dam.rest.dto.model.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetMonumentoDto>> todos() {

        List<Monumento> data = monumentoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();

        // Aquí hacemos la transformación de Monumento -> GetMonumentoDto
        List<GetMonumentoDto> result =
                data.stream()
                        .map(GetMonumentoDto::of)
                        .toList();

        return ResponseEntity.ok(result);

    }

}
