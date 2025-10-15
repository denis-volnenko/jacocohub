package ru.volnenko.cloud.testhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class JacocoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacocoHubApplication.class, args);
	}

}
