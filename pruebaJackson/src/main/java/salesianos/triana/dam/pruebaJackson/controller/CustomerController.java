package salesianos.triana.dam.pruebaJackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import salesianos.triana.dam.pruebaJackson.Model.Customer;
import salesianos.triana.dam.pruebaJackson.Model.CustomerView;
import static salesianos.triana.dam.pruebaJackson.Model.CustomerView.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController(){
        this.customers = List.of(
                Customer.builder()
                        .id(1L)
                        .name("Paco")
                        .lastLogin(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .email("paco@gmail.com")
                        .password("1234")
                        .creditCard("1234")
                        .salary(4000D)
                        .married(true)
                        .year(2004)
                        .build(),
                Customer.builder()
                        .id(2L)
                        .name("Manolo")
                        .lastLogin(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .email("manolo@gmail.com")
                        .password("1234")
                        .creditCard("1234")
                        .salary(4000D)
                        .year(2004)
                        .married(true)
                        .build()
        );
    }
    @GetMapping("/customers/")
    @JsonView(CustomerList.class)
    public List<Customer> getCustomers() {
        return customers;
    }

    @JsonView(CustomerDetail.class)
    @GetMapping("/customers/{id}")
    public Customer getByID(@PathVariable Long id){
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
    @JsonView(CustomerEdit.class)
    @PutMapping("/customers/{id}")
    public Customer editCostumer(@PathVariable Long id){
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
