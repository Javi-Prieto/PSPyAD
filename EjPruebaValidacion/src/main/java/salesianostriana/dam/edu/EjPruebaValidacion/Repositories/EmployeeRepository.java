package salesianostriana.dam.edu.EjPruebaValidacion.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import salesianostriana.dam.edu.EjPruebaValidacion.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
