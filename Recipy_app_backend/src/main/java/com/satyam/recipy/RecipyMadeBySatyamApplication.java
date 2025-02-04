package com.satyam.recipy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RecipyMadeBySatyamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipyMadeBySatyamApplication.class, args);
	}

}
