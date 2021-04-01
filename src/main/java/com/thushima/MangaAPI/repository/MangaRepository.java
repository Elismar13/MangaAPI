package com.thushima.MangaAPI.repository;

import com.thushima.MangaAPI.document.Manga;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MangaRepository extends CrudRepository<Manga, String> {

}
