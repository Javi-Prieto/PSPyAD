package dam.salesianostriana.Test_test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoServicio service;
    @GetMapping("/product/")
    public ResponseEntity<List<Producto>> getAll(){
        return ResponseEntity.ok( service.findAll());
    }

    @GetMapping("/product_less_than_10/")
    public ResponseEntity<List<Producto>> getAllPriceLessThan10(){
        return ResponseEntity.ok(service.findAllProductsPriceLessThan10());
    }
}
