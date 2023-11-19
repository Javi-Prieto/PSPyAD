package com.salesianos.dam.Example_for_Security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor@AllArgsConstructor
@Builder
@Entity
public class Empleado {
    @Id
    @GeneratedValue
    private  Long id;

    private String nombre;
    private String apellidos;
    private double salary;
    private boolean jefe;

    @Builder.Default
    private LocalDateTime signedIn = LocalDateTime.now();
}
