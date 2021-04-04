package com.thushima.MangaAPI;

import com.thushima.MangaAPI.repository.MangaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.thushima.MangaAPI.constans.MangaConstant.MANGA_ENDPOINT_LOCAL;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class MangaApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	MangaRepository mangaRepository;


	@Test
	public void getOneMangaById(){
		webTestClient.get().uri(MANGA_ENDPOINT_LOCAL.concat("/{id}"),"2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneMangaNotFound(){
		webTestClient.get().uri(MANGA_ENDPOINT_LOCAL.concat("/{id}"),"56")
				.exchange()
				.expectStatus().isNotFound();
	}


	@Test
	public void deleteManga(){
		webTestClient.delete().uri(MANGA_ENDPOINT_LOCAL.concat("/{id}"),"15")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}
}

