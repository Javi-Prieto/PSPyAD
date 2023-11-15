package salesianostriana.dam.edu.EjPruebaValidacion.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import salesianostriana.dam.edu.EjPruebaValidacion.DTO.GetEmployeeDTO;
import salesianostriana.dam.edu.EjPruebaValidacion.DTO.POSTEmployeeDTO;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindAll.Custom.EmployeeListNotFoundException;
import salesianostriana.dam.edu.EjPruebaValidacion.Error.CustomError.NotFound.Custom.FindById.Custom.EmployeeNotFoundException;
import salesianostriana.dam.edu.EjPruebaValidacion.Repositories.EmployeeRepository;
import salesianostriana.dam.edu.EjPruebaValidacion.model.Employee;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private  final EmployeeRepository repo;

    public Employee getEmployeeById(Long id){
        return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public List<GetEmployeeDTO> findAllEmployee() {
        List<Employee> all = repo.findAll();
        if(all.isEmpty())
            throw new EmployeeListNotFoundException("Employee");
        return all.stream().map(GetEmployeeDTO::of).toList();
    }

    public Employee createEmployee(POSTEmployeeDTO newEmp) {
        return repo.save(POSTEmployeeDTO.from(newEmp));
    }
}
