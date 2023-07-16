package com.javapavan.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.models.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@OpenAPIDefinition(info = @Info(title = "REST API", version = "1.1",
        contact = @Contact(name = "Pavan", email = "java4Pavan@gmail.com")),
        security = {@SecurityRequirement(name = "basicAuth"), @SecurityRequirement(name = "bearerToken")}
)
@SecuritySchemes({
        @SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic"),
        @SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
})
@ResponseBody
public class OpenApiConfig {
//    @Bean
//    public OpenAPI moviesMicroserviceOpenAPI() {
////        List<SecurityRequirement> security =new ArrayList<>();
////        security.add((SecurityRequirement) Builder.securityRequirementBuilder().name("bearerToken").build());
////        security.add((SecurityRequirement) Builder.securityRequirementBuilder().name("basicAuth").build());
//
//        return new OpenAPI()
//                .info(new io.swagger.v3.oas.models.info.Info().title("Employee Service")
//                        .description("Employee Details Service")
//                        .version("1.0")
//                        .contact(new io.swagger.v3.oas.models.info.Contact()
//                                .name("Pavan Balasani")
//                                .email("pavanbalasani@gmail.com")));
//    }
}