package com.pmi.aplicacao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Api da Project Manager Instance", version = "1", description = "Api que promove gestão de projetos."))
public class AplicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoApplication.class, args);
	}

}
