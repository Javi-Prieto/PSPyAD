package dam.salesianostriana.Test_test;

import lombok.Builder;

@Builder
public record GetProductoDTO(String name) {
    public static GetProductoDTO of(Producto from){
        return GetProductoDTO.builder().name(from.getName()).build();
    }
}
