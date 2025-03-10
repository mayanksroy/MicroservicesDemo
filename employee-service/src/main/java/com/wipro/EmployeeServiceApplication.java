package com.wipro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	
	//RestTemplateCommunication
//	@Bean
//	public RestTemplate getTemplate()
//	{
//		return new RestTemplate();
//	}
	
	//WebClientCommunication
	@Bean
	public WebClient webClient()
	{
		return WebClient.builder().build();
	}
}
