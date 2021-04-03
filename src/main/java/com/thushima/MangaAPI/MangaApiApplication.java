package com.thushima.MangaAPI;

import com.thushima.MangaAPI.document.Manga;
import com.thushima.MangaAPI.repository.MangaRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDynamoDBRepositories
public class MangaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApiApplication.class, args);
//		System.out.println("Spring com webflux");
	}

}
