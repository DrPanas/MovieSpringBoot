package com.springBootFirstApp.Movie.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Writers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_writer;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=3,max=30,message = "Name should be between 3 and 30 characters")
    private String name_writer;

    @ManyToMany
    @JoinTable(name = "writers_movie",
            joinColumns = @JoinColumn(name = "id_writer"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private Set<Movie> moviesSet;

    public int getId_writer() {
        return id_writer;
    }

    public void setId_writer(int id_writer) {
        this.id_writer = id_writer;
    }

    public String getName_writer() {
        return name_writer;
    }

    public void setName_writer(String name_writer) {
        this.name_writer = name_writer;
    }

    public Set<Movie> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movie> moviesSet) {
        this.moviesSet = moviesSet;
    }
}
