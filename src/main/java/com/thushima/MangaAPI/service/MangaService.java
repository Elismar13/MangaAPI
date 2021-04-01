package com.thushima.MangaAPI.service;

import com.thushima.MangaAPI.document.Manga;
import com.thushima.MangaAPI.repository.MangaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MangaService {
    private final MangaRepository mangaRepository;

    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public Flux<Manga> findAll() {
        return Flux.fromIterable(mangaRepository.findAll());
    }

    public Mono<Manga> findById(String id) {
        return Mono.justOrEmpty(mangaRepository.findById(id));
    }

    public Mono<Manga> save(Manga manga) {
        return Mono.justOrEmpty(mangaRepository.save(manga));
    }

    public void deleteById(String id) {
        mangaRepository.deleteById(id);
    }
}
