package com.springBootFirstApp.Movie.controllers;

import com.springBootFirstApp.Movie.entity.Genres;
import com.springBootFirstApp.Movie.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresRepository genresRepository;

    @GetMapping
    public String allGenres(Model model){
        model.addAttribute("genres",genresRepository.findAll());
        return "genresViews/allGenres";
    }

    @GetMapping("/{id}")
    public String genreByID(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genresRepository.findById(id).get());
        return "genresViews/genreById";
    }



    @GetMapping("/new")
    public String newGenre(@ModelAttribute("genre")Genres genre) {
        return "genresViews/newGenre";
    }
    @PostMapping
    public String createGenre(@ModelAttribute("genre") @Valid Genres genre, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "genresViews/newGenre";
        }
        genresRepository.save(genre);
        return "redirect:/genres";
    }



    @GetMapping("/{id}/update")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("genre",genresRepository.findById(id).get());
        return "genresViews/updateGenre";

    }
    @PostMapping("/{id}/update")
    public String update( @ModelAttribute("genre") @Valid Genres genre, BindingResult bindingResult ,
                          @PathVariable(name = "id") int id) {
        if(bindingResult.hasErrors()){
            return "genresViews/updateGenre";
        }
        genresRepository.save(genre);
        return "redirect:/genres";
    }



    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute("genre") Genres genre, @PathVariable(name = "id") int id) {
        genresRepository.deleteById(id);
        return "redirect:/genres";
    }
}
