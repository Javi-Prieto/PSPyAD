package com.salesianostriana.dam.rest.dto.model.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Empoloyees {
    //Así indicamos cada uno de los atributos con una breve descripción
    @Schema(example = "4", description = "identificador de empleado númerico autoincrementado")
    private Long id;

    @Schema(example = "Manolo", description = "Nombre completo Empleado")
    private String nombre;

    @Schema(example = "22/03/2004", description = "Fecha nacimiento del empleado dd/mm/yyyy")
    private LocalDate birthDate;

    @Schema(example = "32564.23", description = "Salario anual bruto del empleado")
    private double salary;

    @Schema(example = "true", description = "Situacion sentimental del empleado")
    private boolean married;
}
