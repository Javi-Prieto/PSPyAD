package com.example.exampleForDBConnection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Alumno {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
}
