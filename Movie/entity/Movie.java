package com.springBootFirstApp.Movie.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movie;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=3,max=30,message = "Name should be between 3 and 30 characters")
    private String title;

    @NotBlank(message =  "Name should not be empty")
    @Size(min=10,max=1000,message = "Name should be between 10 and 1000 characters")
    private String description;

    @ManyToMany
    @JoinTable(name = "actors_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private Set<Actors> actorsSet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_director", referencedColumnName = "id")
    private Directors director;


    @ManyToMany
    @JoinTable(name = "writers_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_writer"))
    private Set<Writers> writersSet;


    @ManyToMany
    @JoinTable(name = "genres_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private Set<Genres> genresSet;

    public Integer getId_movie() {
        return id_movie;
    }

    public void setId_movie(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actors> getActorsSet() {
        return actorsSet;
    }

    public void setActorsSet(Set<Actors> actorsSet) {
        this.actorsSet = actorsSet;
    }

    public Set<Genres> getGenresSet() {
        return genresSet;
    }

    public void setGenresSet(Set<Genres> genresSet) {
        this.genresSet = genresSet;
    }

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }

    public Set<Writers> getWritersSet() {
        return writersSet;
    }

    public void setWritersSet(Set<Writers> writersSet) {
        this.writersSet = writersSet;
    }
}
