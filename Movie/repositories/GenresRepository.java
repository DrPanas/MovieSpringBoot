package com.springBootFirstApp.Movie.repositories;

import com.springBootFirstApp.Movie.entity.Genres;
import org.springframework.data.repository.CrudRepository;

public interface GenresRepository extends CrudRepository<Genres,Integer> {
}
