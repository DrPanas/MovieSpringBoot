package com.springBootFirstApp.Movie.repositories;

import com.springBootFirstApp.Movie.entity.Writers;
import org.springframework.data.repository.CrudRepository;

public interface WritersRepository extends CrudRepository<Writers,Integer> {
}
