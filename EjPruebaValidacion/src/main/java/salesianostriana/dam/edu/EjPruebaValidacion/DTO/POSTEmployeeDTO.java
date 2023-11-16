package salesianostriana.dam.edu.EjPruebaValidacion.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import salesianostriana.dam.edu.EjPruebaValidacion.model.Employee;

@Builder
public record POSTEmployeeDTO(
    @NotBlank(message = "El nombre del empleado no puede estar en blanco")
    String nombre,
    @NotBlank(message = "{POSTEmployeeDTO.apellido.notBlank}")
    String apellidos,
    @Min(value = 0, message = "{POSTEmployeeDTO.salary.min}")
    Double salary,
    @Email(message = "{POSTEmployeeDTO.email.email}")
    @NotBlank(message = "El email no puede estar en blanco")
    String email
) {
    public static Employee from(POSTEmployeeDTO e){
        return Employee.builder()
                .email(e.email)
                .nombre(e.nombre)
                .apellidos(e.apellidos)
                .salary(e.salary)
                .build();
    }
}
