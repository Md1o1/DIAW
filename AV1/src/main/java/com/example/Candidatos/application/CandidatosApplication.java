package com.example.Candidatos.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class CandidatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatosApplication.class, args);
	}

}
