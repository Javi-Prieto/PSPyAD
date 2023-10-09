package com.salesianostriana.dam.rest.dto.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.rest.dto.model.views.CategoriaView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.salesianostriana.dam.rest.dto.model.views.CategoriaView.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id @GeneratedValue
    @JsonView(CategoriaList.class)
    private Long id;

    @JsonView(CategoriaList.class)
    private String nombre;
}
