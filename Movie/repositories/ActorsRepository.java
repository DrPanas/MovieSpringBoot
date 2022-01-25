package com.springBootFirstApp.Movie.repositories;

import com.springBootFirstApp.Movie.entity.Actors;
import org.springframework.data.repository.CrudRepository;

public interface ActorsRepository extends CrudRepository<Actors, Integer> {

}
