package com.salesianos.dam.Example_for_Security.repo;

import com.salesianos.dam.Example_for_Security.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepoitorio extends JpaRepository<Empleado, Long> {

    List<Empleado> findByNombre(String Nombre);
}
