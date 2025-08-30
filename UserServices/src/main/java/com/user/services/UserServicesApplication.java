package com.user.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
public class UserServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServicesApplication.class, args);
	}

}
