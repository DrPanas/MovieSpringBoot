package com.springBootFirstApp.Movie.controllers;

import com.springBootFirstApp.Movie.entity.Directors;
import com.springBootFirstApp.Movie.repositories.DirectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/directors")
public class DirectorsController {

    @Autowired
    private DirectorsRepository directorsRepository;

    @GetMapping
    public String allDirectors(Model model){
        model.addAttribute("directors",directorsRepository.findAll());
        return "directorsViews/allDirectors";
    }


    @GetMapping("/{id}")
    public String directorByID(@PathVariable("id") int id, Model model) {
            model.addAttribute("director", directorsRepository.findById(id).get());
            return "directorsViews/directorById";
    }


    @GetMapping("/new")
    public String newDirector(@ModelAttribute("director")  Directors director) {
        return "directorsViews/newDirector";
    }

    @PostMapping
    public String createDirector(@ModelAttribute("director") @Valid Directors director, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "directorsViews/newDirector";
        }
        directorsRepository.save(director);
        return "redirect:/directors";
    }


    @GetMapping("/{id}/update")
    public String edit(@PathVariable(name = "id") int id, Model model) {
            model.addAttribute("director", directorsRepository.findById(id).get());
            return "directorsViews/updateDirector";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable(name = "id") int id, @ModelAttribute("director") @Valid Directors director,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "directorsViews/updateDirector";
        }
            directorsRepository.save(director);
        return "redirect:/directors";
    }

    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute("director") Directors director, @PathVariable(name = "id") int id) {
            directorsRepository.deleteById(id);
        return "redirect:/directors";
    }
}
