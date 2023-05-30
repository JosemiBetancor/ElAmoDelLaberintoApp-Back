package com.minik.laberinto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = { "http://localhost:8080" })
@SpringBootApplication
@ComponentScan(basePackages = "com.minik.laberinto.*")
public class ElAmoDelLaberintoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ElAmoDelLaberintoApplication.class, args);
	}

}
