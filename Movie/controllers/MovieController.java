package com.springBootFirstApp.Movie.controllers;


import com.springBootFirstApp.Movie.entity.Movie;
import com.springBootFirstApp.Movie.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private ActorsRepository actorsRepository;

    @Autowired
    private DirectorsRepository directorsRepository;

    @Autowired
    private WritersRepository writersRepository;

    @Autowired
    private GenresRepository genresRepository;

    @GetMapping
    public String allMovie(Model model) {
        model.addAttribute("movies", moviesRepository.findAll());
        return "movieViews/allMovies";
    }

    @GetMapping("/{id}")
    public String movieByID(@PathVariable("id") int id, Model model) {
        model.addAttribute("movie", moviesRepository.findById(id).get());
        return "movieViews/movieById";
    }

    @GetMapping("/new")
    public String newMovie(@ModelAttribute("movie") Movie movie, Model model) {
        model.addAttribute("actors", actorsRepository.findAll());
        model.addAttribute("genres", genresRepository.findAll());
        model.addAttribute("writers",writersRepository.findAll());
        model.addAttribute("directors", directorsRepository.findAll());
        return "movieViews/newMovie";
    }

    @PostMapping()
    public String createMovie(@ModelAttribute("movie") @Valid Movie movie, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "movieViews/newMovie";
        }
        moviesRepository.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("movie",moviesRepository.findById(id).get());
        model.addAttribute("directors",directorsRepository.findAll());
        model.addAttribute("actors",actorsRepository.findAll());
        model.addAttribute("writers",writersRepository.findAll());
        model.addAttribute("genres",genresRepository.findAll());
        return "movieViews/updateMovie";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @ModelAttribute("movie") @Valid Movie movie,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "movieViews/updateMovie";
        }
        moviesRepository.save(movie);
        return "redirect:/movies";
    }
    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("movie") @PathVariable("id") int id) {
       moviesRepository.deleteById(id);
        return "redirect:/movies";
    }
}
