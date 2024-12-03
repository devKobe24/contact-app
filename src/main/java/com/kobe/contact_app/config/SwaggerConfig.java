package com.kobe.contact_app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Contact App API")
                        .version("1.0.0")
                        .description("API documentation for the Contact App")
                        .contact(new Contact()
                                .name("Kobe")
                                .email("dev.skyachieve91@gmail.com")
                                .url("https://www.devkobe24.com/")
                        )
                );
    }
}
