package com.salesianostriana.dam.rest.dto.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.rest.dto.model.views.RutaView.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id @GeneratedValue
    @JsonView(RutaList.class)
    private Long id;

    @JsonView(RutaList.class)
    private String nombre;

    @JsonView(RutaList.class)
    private int tiempo; // en minutos

    @Enumerated(EnumType.STRING)
    @JsonView(RutaList.class)
    private Dificultad dificultad;

    @ManyToMany
    @JsonView(RutaList.class)
    private List<Monumento> monumentos;

}
