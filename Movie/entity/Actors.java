package com.springBootFirstApp.Movie.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Actors {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_actor;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=3,max=30,message = "Name should be between 3 and 30 characters")
    private String name_actor;

    @ManyToMany
    @JoinTable(name = "actors_movie",
            joinColumns = @JoinColumn(name = "id_actor"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private Set<Movie> moviesSet;

    public Integer getId_actor() {
        return id_actor;
    }

    public void setId_actor(Integer id_actor) {
        this.id_actor = id_actor;
    }

    public String getName_actor() {
        return name_actor;
    }

    public void setName_actor(String name_actor) {
        this.name_actor = name_actor;
    }

    public Set<Movie> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movie> moviesSet) {
        this.moviesSet = moviesSet;
    }



}
