package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendApplication {

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}