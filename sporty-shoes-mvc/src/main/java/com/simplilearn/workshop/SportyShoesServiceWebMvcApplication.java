package com.simplilearn.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SportyShoesServiceWebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesServiceWebMvcApplication.class, args);
	}

}
