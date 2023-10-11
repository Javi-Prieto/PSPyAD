package com.salesianostriana.dam.rest.dto.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiCOnfig {
    //Esta es una forma de documentar pero también se podría hacer con Comentarios

    //Con esto hacemos una documentacion podemos acceder a ella con http://localhost:8080/v3/api-docs
    //Para poder irla actualizando a medida que vamos programando
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                                        .title("ExampleAPI")
                .description("API Rest para los empleados")
                .version("v.0.0.1")
                .license(new License().name("Apache 2.0").url("https://wwww.example.com/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Wiki Docs")
                        .url("https://www.example.com/"));
    }
}
