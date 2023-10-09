package com.salesianostriana.dam.rest.dto.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.rest.dto.model.entities.Monumento;
import com.salesianostriana.dam.rest.dto.model.repos.MonumentoRepository;
import com.salesianostriana.dam.rest.dto.model.views.MonumentoView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salesianostriana.dam.rest.dto.model.views.MonumentoView.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/")
    @JsonView(MonumentoList.class)
    public ResponseEntity<List<Monumento>> todos() {

        List<Monumento> data = monumentoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();

        // Aquí hacemos la transformación de Monumento -> GetMonumentoDto

        return ResponseEntity.ok(data);

    }

    @GetMapping("/{id}")
    @JsonView(MonumentoDetails.class)
    public ResponseEntity<Monumento> porId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

}
