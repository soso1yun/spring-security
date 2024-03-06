package com.example.springsecurity.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Spring Security",
                description = "Spring Security JWT",
                version = "v1.0"
        )
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi openAPI() {
        return GroupedOpenApi.builder()
                .group("Spring Security v1")
                .pathsToMatch("/**")
                .build();
    }

}
