package dev.martin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.martin")
@EntityScan(basePackages = "dev.martin.entities")
@EnableJpaRepositories(basePackages = "dev.martin.repos")
public class HighScoreSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighScoreSpringApplication.class, args);
	}

}
