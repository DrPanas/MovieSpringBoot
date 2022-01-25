package com.springBootFirstApp.Movie.repositories;

import com.springBootFirstApp.Movie.entity.Directors;
import org.springframework.data.repository.CrudRepository;

public interface DirectorsRepository extends CrudRepository<Directors,Integer> {
}
