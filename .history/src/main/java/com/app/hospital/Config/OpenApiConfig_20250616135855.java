package com.app.hospital.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiDoc() {
        final String securitySchemeName = "ShettyToken";

        return new OpenAPI()
                .info(new Info()
                        .title("Hospital API")
                        .description("Spring Boot 3 REST API secured with JWT")
                        .version("1.0"))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("Shetty")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName));
    }
}