package com.example.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demomvc.model.Person;



@Controller
public class PersonController {
    
    @GetMapping("/showPerson")
    public String showPerson(Model model) {
        Person person = new Person();
         person.setName("John Doe");
        person.setAge(30);
 
        model.addAttribute("person", person);
        return "person";
    }
    
}
