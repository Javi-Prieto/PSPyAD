package dam.salesianostriana.Test_test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    List<Producto> findByPriceLessThan(double precio);
}
