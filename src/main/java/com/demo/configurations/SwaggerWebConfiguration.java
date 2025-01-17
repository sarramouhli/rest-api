package com.demo.configurations;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerWebConfiguration {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.demo.controllers")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Spring Boot Rest Api", "This is a rest apit for spring boot", "1.0.1",
				"This is free Licence version",
				new springfox.documentation.service.Contact("Sarah Mouhli", "https://github.com/sarramouhli",
						"sarramouhligh@gmail.com"),
				"API License", "https://github.com/sarramouhli", Collections.emptyList());
	}

}
