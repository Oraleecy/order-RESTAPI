package com.restapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.restapi.models")
@EnableJpaRepositories("com.restapi.repositories")
public class RestapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
