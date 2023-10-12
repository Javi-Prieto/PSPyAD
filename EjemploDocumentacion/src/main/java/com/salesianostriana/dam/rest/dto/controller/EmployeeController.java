package com.salesianostriana.dam.rest.dto.controller;

import com.salesianostriana.dam.rest.dto.model.entities.Empoloyees;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    //En hhtps://localhost:8080/v3/api-docs tendremos la documentación en formato JSON y esta la podríamos importar en postman por ejemplo para realizar peticiones
    //En postMan se podrían realizar comprobaciones de sí tenemos la documentación
    //En https://localhost:8080/swagger-ui/index.html tendremos la dcumentación mostrada de forma visual en una página web
    //ApiResponses nos aclará cuáles va a ser las respuestas que nos va a dar este método
    @ApiResponses(value = {
            //Haremos un ApiResponse por cada uno de las posibles respuestas
            @ApiResponse(responseCode = "200", description = "Get Employees",content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Empoloyees.class)))}),
            @ApiResponse(responseCode = "404", description = "Not Found",content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Empoloyees.class)))})
    })
    //Aquí en operation debemos escribir un pequeño resumen y una descripción de que hace el método
    @Operation(summary = "Find All Employees", description = "It returns all employees without pagination")
    @GetMapping("/employee/")
    public ResponseEntity<List<Empoloyees>> findAll(/*@Parameter lo podríamos en cada uno de los parámetros para que nos lo indicase en la documentación*/){
        return null;
    }
    //@Hidden podríamos esconder lo que quisieramos de la información
}
