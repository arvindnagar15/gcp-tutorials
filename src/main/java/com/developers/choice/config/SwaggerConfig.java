package com.developers.choice.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket documentation() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.developers.choice.controller"))            
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metadata())
          .pathMapping("/")
          .directModelSubstitute(LocalDate.class, String.class)
          .genericModelSubstitutes(ResponseEntity.class);
    }
	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Developers choice example")
				.description("Developers choice example")
				.version("1.0")
				.build();
	}
}
