package net.javaguides.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients

public class EmployeeServiceApplication {

//  @Bean
//  public RestTemplate restTemplate(){
//    return new RestTemplate();
//  }

  @Bean
  public WebClient webClient(){
    return WebClient.builder().build();
  }
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
