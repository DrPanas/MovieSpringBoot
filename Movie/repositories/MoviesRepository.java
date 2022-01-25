package com.springBootFirstApp.Movie.repositories;

import com.springBootFirstApp.Movie.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie,Integer> {
}
