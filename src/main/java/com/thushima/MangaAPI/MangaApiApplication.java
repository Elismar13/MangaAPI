package com.thushima.MangaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MangaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApiApplication.class, args);
		System.out.println("Spring com webflux");
	}

}
