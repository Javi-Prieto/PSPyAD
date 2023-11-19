package com.salesianos.dam.Example_for_Security.Controlador;

import com.salesianos.dam.Example_for_Security.model.Empleado;
import com.salesianos.dam.Example_for_Security.repo.EmpleadoRepoitorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleado")
public class EmpleadoController {
    private final EmpleadoRepoitorio repo;

    @GetMapping("/")
    public ResponseEntity<List<Empleado>> getAll(){
        List<Empleado> result = repo.findAll();
        return result.isEmpty()? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Long id){
        return ResponseEntity.of(repo.findById(id));
    }
}
