package salesianostriana.dam.edu.EjPruebaValidacion.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import salesianostriana.dam.edu.EjPruebaValidacion.model.Employee;

@Builder
@Data
@AllArgsConstructor
public record GetEmployeeDTO(
        String nombreCompleto,
        Double salary
) {
    public static GetEmployeeDTO of(Employee e){
        return GetEmployeeDTO.builder()
                .nombreCompleto(e.getNombre() + " " +e.getApellidos())
                .salary(e.getSalary())
                .build();
    }
}
