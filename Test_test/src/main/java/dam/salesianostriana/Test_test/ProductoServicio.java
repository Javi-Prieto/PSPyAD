package dam.salesianostriana.Test_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio {
    private final ProductoRepositorio repo;

    public Producto save(Producto p){
        return repo.save(p);
    }
    public List<Producto> saveAll(List<Producto> p){
        return repo.saveAll(p);
    }

    public List<Producto> findAll(){
        return repo.findAll();
    }

    public List<Producto> findAllProductsPriceLessThan10(){
        return repo.findByPriceLessThan(10);
    }

    public List<GetProductoDTO> precioMenorQue10YDisponible(){
        List<Producto> all = repo.findAll();
        List<GetProductoDTO> result = new ArrayList<>();

        for(Producto p : all){
            if(p.getPrice() < 10){
                if(p.isAvailable())
                    result.add(GetProductoDTO.of(p));
            }
        }
        if(result.isEmpty())
            return null;
        return result;
    }
}
