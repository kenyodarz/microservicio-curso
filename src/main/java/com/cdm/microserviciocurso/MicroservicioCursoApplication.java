package com.cdm.microserviciocurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursoApplication.class, args);
	}

}
