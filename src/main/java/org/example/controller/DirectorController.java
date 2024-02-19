package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.persons.Director;
import org.example.repository.DirectorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/directors")
@Slf4j
public class DirectorController {
    private final DirectorRepository directorRepository;

    @GetMapping
    public ModelAndView showAll(ModelAndView model) {
        List<Director> directors = directorRepository.findAll();
        model.addObject("directors", directors);
        model.setViewName("listDirector");
        return model;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("createDirector");
        Director director = new Director();
        modelAndView.addObject(director);
        //modelAndView.addObject("priorities", Priority.values());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid Director director,
                         BindingResult bindingResult) {
        log.info("#director " + director);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        directorRepository.create(director);
        return "redirect:/directors";
    }
}
