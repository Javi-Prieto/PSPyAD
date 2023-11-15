package salesianostriana.dam.edu.EjPruebaValidacion.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import salesianostriana.dam.edu.EjPruebaValidacion.DTO.GetEmployeeDTO;
import salesianostriana.dam.edu.EjPruebaValidacion.DTO.POSTEmployeeDTO;
import salesianostriana.dam.edu.EjPruebaValidacion.Services.EmployeeService;
import salesianostriana.dam.edu.EjPruebaValidacion.model.Employee;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }
    @GetMapping("/")
    public List<GetEmployeeDTO> getEmployeeList(){
        return service.findAllEmployee();
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody POSTEmployeeDTO newEmp){
        Employee created = service.createEmployee(newEmp);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(createdURI).body(created);
    }
}
