package com.springBootFirstApp.Movie.controllers;


import com.springBootFirstApp.Movie.entity.Writers;
import com.springBootFirstApp.Movie.repositories.WritersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/writers")
public class WriterController {

    @Autowired
    private WritersRepository writersRepository;

    @GetMapping
    public String allGenres(Model model){
        model.addAttribute("writers",writersRepository.findAll());
        return "writersViews/allWriters";
    }

    @GetMapping("/{id}")
    public String writerByID(@PathVariable("id") int id, Model model) {
        model.addAttribute("writer", writersRepository.findById(id).get());
        return "writersViews/writerById";
    }

    @GetMapping("/new")
    public String newWriter(@ModelAttribute("writer") Writers writer) {
        return "writersViews/newWriter";
    }

    @PostMapping
    public String createWriter(@ModelAttribute("writer") @Valid Writers writer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "writersViews/newWriter";
        }
        writersRepository.save(writer);
        return "redirect:/writers";
    }


    @GetMapping("/{id}/update")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("writer", writersRepository.findById(id).get());
        return "writersViews/updateWriter";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable(name = "id") int id, @ModelAttribute("writer") @Valid Writers writer,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "writersViews/updateWriter";
        }
        writersRepository.save(writer);
        return "redirect:/writers";
    }

    @PostMapping("{id}/delete")
    public String delete(@ModelAttribute("writer") Writers writers, @PathVariable(name = "id") int id) {
        writersRepository.deleteById(id);
        return "redirect:/writers";
    }


}
