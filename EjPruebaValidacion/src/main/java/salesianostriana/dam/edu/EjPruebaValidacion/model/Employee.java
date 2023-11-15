package salesianostriana.dam.edu.EjPruebaValidacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    @Builder.Default
    private LocalDate fechaEntrada = LocalDate.now();
    private double salary;
    private String apellidos;
    private String email;

}
