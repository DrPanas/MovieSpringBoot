package com.springBootFirstApp.Movie.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Directors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=3,max=30,message = "Name should be between 3 and 30 characters")
    private String name_director;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id_movie")
    private Set<Movie> moviesSet;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_director() {
        return name_director;
    }

    public void setName_director(String name_director) {
        this.name_director = name_director;
    }

    public Set<Movie> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movie> moviesSet) {
        this.moviesSet = moviesSet;
    }
}
