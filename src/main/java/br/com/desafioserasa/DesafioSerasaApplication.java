package br.com.desafioserasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@EnableJpaAuditing
public class DesafioSerasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSerasaApplication.class, args);
	}

}
