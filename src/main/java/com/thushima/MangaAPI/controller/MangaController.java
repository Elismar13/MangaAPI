package com.thushima.MangaAPI.controller;

import com.thushima.MangaAPI.document.Manga;
import com.thushima.MangaAPI.repository.MangaRepository;
import com.thushima.MangaAPI.service.MangaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.thushima.MangaAPI.constans.MangaConstant.MANGA_ENDPOINT_LOCAL;

@RestController
@Slf4j
@RequestMapping(MANGA_ENDPOINT_LOCAL)
public class MangaController {
    MangaService mangaService;

    MangaRepository mangaRepository;

    public MangaController(MangaService mangaService, MangaRepository mangaRepository) {
        this.mangaService = mangaService;
        this.mangaRepository = mangaRepository;
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MangaController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Manga> getAllItems() {
        log.info("requesting the list off all mangas");
        return mangaService.findAll();
    }


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Manga>> findById(@PathVariable String id) {
        log.info("Requesting the manga with id {}", id);
        return mangaService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Manga> createManga(@RequestBody Manga manga) {
        log.info("A new Manga was Created");
        return mangaService.save(manga);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyID(@PathVariable String id) {
        mangaService.deleteById(id);
        log.info("Deleting the manga with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}