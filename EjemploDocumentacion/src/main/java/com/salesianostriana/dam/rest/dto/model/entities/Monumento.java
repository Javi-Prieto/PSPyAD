package com.salesianostriana.dam.rest.dto.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.rest.dto.model.views.MonumentoView.*;

import java.util.List;

@Entity
@Data // Jpa Buddy
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id @GeneratedValue
    @JsonView(MonumentoList.class)
    private Long id;

    @JsonView(MonumentoDetails.class)
    private String codigoPais;

    @JsonView(MonumentoDetails.class)
    private String pais;

    @JsonView(MonumentoList.class)
    private String ciudad;

    @JsonView(MonumentoList.class)
    private String loc;

    @JsonView(MonumentoList.class)
    private String nombre;

    @JsonView(MonumentoDetails.class)
    private String descripcion;

    @ElementCollection // Obligatoria en Spring Boot 2.
    @JsonView(MonumentoList.class)
    private List<String> imagenes;

    @ManyToOne
    @JsonView(MonumentoList.class)
    private Categoria categoria;


}
