package br.com.marcosmendes.springcustomerapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Customer API", version = "1.0.0", description = "A Spring Boot API for Customer Management."))
public class SpringCustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCustomerApiApplication.class, args);
	}

}
