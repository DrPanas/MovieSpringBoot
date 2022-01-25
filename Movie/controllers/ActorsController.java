package com.springBootFirstApp.Movie.controllers;

import com.springBootFirstApp.Movie.entity.Actors;
import com.springBootFirstApp.Movie.repositories.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private ActorsRepository actorsRepository;

    @GetMapping
    public String allActors(Model model){
        model.addAttribute("actors",actorsRepository.findAll());
        return "actorsViews/allActors";
    }

    @GetMapping("/{id}")
    public String actorByID(@PathVariable("id") int id, Model model) {
            model.addAttribute("actor", actorsRepository.findById(id).get());
            return "actorsViews/actorById";
    }



    @GetMapping("/new")
    public String newActor(@ModelAttribute("actor") Actors actor) {
        return "actorsViews/newActor";
    }
    @PostMapping
    public String createActor(@ModelAttribute("actor") @Valid Actors actor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "actorsViews/newActor";
        }
        actorsRepository.save(actor);
        return "redirect:/actors";
    }



    @GetMapping("/{id}/update")
    public String edit(@PathVariable(name = "id") int id, Model model) {
       model.addAttribute("actor",actorsRepository.findById(id).get());
            return "actorsViews/updateActor";

    }
    @PostMapping("/{id}/update")
    public String update( @PathVariable(name = "id") int id , @ModelAttribute("actor") @Valid Actors actor,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "actorsViews/updateActor";
        }
       actorsRepository.save(actor);
        return "redirect:/actors";
    }


    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute("actor") Actors actor, @PathVariable(name = "id") int id) {
         actorsRepository.deleteById(id);
        return "redirect:/actors";
    }
}
