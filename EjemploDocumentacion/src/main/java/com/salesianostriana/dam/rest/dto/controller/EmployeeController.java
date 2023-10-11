package com.salesianostriana.dam.rest.dto.controller;

import com.salesianostriana.dam.rest.dto.model.entities.Empoloyees;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name ="Employee", description = "Employee API REST controller with CRUD operators")
public class EmployeeController {

    @ApiResponses
    @GetMapping("/employee/")
    @Operation(summary = "Find All Employees", description = "It returns all employees without pagination")
    public ResponseEntity<List<Empoloyees>> findAll(){
        return null;
    }
}
