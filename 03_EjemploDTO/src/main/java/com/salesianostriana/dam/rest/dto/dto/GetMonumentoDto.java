package com.salesianostriana.dam.rest.dto.dto;

import com.salesianostriana.dam.rest.dto.model.Monumento;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public record GetMonumentoDto (Long id, String nombre, String localizacion, String urlFoto
                                , String nombreCategoria) {
    public static GetMonumentoDto of(Monumento monumento) {
        return GetMonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombre())
                .localizacion(monumento.getLoc())
                .urlFoto(monumento.getUrlImagen())
                .nombreCategoria(
                        monumento.getCategoria() != null
                                ? monumento.getCategoria().getNombre()
                                : "Sin categoría"
                )
                .build();
    }

}
