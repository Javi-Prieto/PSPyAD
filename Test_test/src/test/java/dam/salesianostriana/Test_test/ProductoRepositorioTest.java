package dam.salesianostriana.Test_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductoRepositorioTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductoRepositorio repositorio;

    @Test
    void precioMenorQue(){
        entityManager.persist(Producto.builder().name("Patatas").price(10.3).build());
        entityManager.persist(Producto.builder().name("Sangría").price(4.32).build());
        entityManager.persist(Producto.builder().name("Sangría").price(10).build());

        List<Producto> result = repositorio.findByPriceLessThan(10);
        assertEquals(1, result.size());
        assertEquals(4.32, result.get(0).getPrice());
        assertEquals("Sangría", result.get(0).getName());
    }

}
