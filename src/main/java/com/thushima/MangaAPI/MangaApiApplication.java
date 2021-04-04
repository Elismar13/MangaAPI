package com.thushima.MangaAPI;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.thushima.MangaAPI.repository")
public class MangaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApiApplication.class, args);
//		System.out.println("Spring com webflux");
	}

}
