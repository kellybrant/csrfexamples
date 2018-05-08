package org.example.csrf.controller;

import java.util.Map;

import javax.validation.Valid;

import org.example.csrf.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/csrfformtest")
public class CsrfFormTestController {

    @GetMapping
    public String helloWorld(Map<String, Object> model){
    	Person person = new Person();
        person.lastName = "Doe";
        model.put("name", "World");
        model.put("person", person);
        model.put("run", model.get("person"));
        return "csrfformtest";
    }

    @PostMapping
    public ModelAndView submit(@Valid @ModelAttribute("person") Person person, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("csrfformtest");
        if(result.hasErrors()){
            log.info("Has errors");
        }
        log.info(person.toString());
        return modelAndView;
    }

}
