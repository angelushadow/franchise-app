package com.mickey.franchise.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Franchise API")
                .description("API para gestionar franquicias, sucursales y productos")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Equipo de Soporte")
                    .email("soporte@franchiseapp.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org")))
            .externalDocs(new ExternalDocumentation()
                .description("Documentación Adicional")
                .url("https://github.com/angelushadow/franchise-app"));
    }
}