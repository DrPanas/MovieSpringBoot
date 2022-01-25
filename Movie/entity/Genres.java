package com.springBootFirstApp.Movie.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_genre;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=3,max=30,message = "Name should be between 3 and 30 characters")
    private String name_genre;

    @ManyToMany
    @JoinTable(name = "genres_movie",
            joinColumns = @JoinColumn(name = "id_genre"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private Set<Movie> moviesSet;

    public Integer getId_genre() {
        return id_genre;
    }

    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    public String getName_genre() {
        return name_genre;
    }

    public void setName_genre(String name_genre) {
        this.name_genre = name_genre;
    }

    public Set<Movie> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movie> moviesSet) {
        this.moviesSet = moviesSet;
    }
}
