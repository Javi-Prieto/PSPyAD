package salesianos.triana.dam.pruebaJackson.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static salesianos.triana.dam.pruebaJackson.Model.CustomerView.*;
import java.time.LocalDateTime;
/*
* Jackson lo vamos a usar para cuando tengamos casos como este en el que no siempre vayamos a mostrar todos los campos que tengamos.
* Al tener tantos campos necesitaremos probablementes distintas vistas
* No vamos a estar creaon DTOs para todos entonces mejor usar Jackson.
* */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    //Con esta anotación lo que vamos a generar es que el dato sobre la que este se muestre en la clase seleccionada
    @JsonView(CustomerList.class)
    private Long id;

    @JsonView(CustomerDetail.class)
    private String name;

    @JsonView({CustomerList.class, CustomerEdit.class})
    private String email;
    //Hacemos que se ignore en cualquier vista para que no se pueda ver la contraseña
    @JsonIgnore
    private String password;

    @JsonView({CustomerList.class, CustomerEdit.class})
    private String creditCard;
    @JsonView(CustomerDetail.class)
    private LocalDateTime createdAt;
    @JsonView(CustomerDetail.class)
    private LocalDateTime lastLogin;
    @JsonView(CustomerDetail.class)
    private Double salary;
    @JsonView(CustomerDetail.class)
    private Integer year;
    private Boolean married;

}
