package com.thekleinbottle.as_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI asOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Atlas Solutions")
                .version("1.0"));
    }
}
