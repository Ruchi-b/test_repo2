package com.zensar.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaServer

public class Eurekaserver1Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaserver1Application.class, args);
		//this is a change
		System.out.println("This is change");
		System.out.println("This is change 2");
	}

}
