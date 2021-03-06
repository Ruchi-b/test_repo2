package com.olx;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OlxLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
	}
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.olx"))
				//.paths(PathSelectors.ant("/olx/login/*"))
				.paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
		
	}
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo(
		"Login Rest API Documentation",
		"This page gives REST API documentation for olx Login ",
		"2.5",
		"My Terms of Service",
		new Contact("Ruchi Bhardwaj","http://ruchi.com","ruchi.bhardwaj@zensar.com"),
		"GPL",
		"http://gpl.org",
		new ArrayList<VendorExtension>());



		return apiInfo;
		
	}

}
