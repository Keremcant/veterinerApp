package com.example.veterinerApp.controller;


import com.example.veterinerApp.model.Pet;
import com.example.veterinerApp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/")
    public String index(Model model) {
        List<Pet> pets = petService.getAll();
        model.addAttribute("pets", pets);
        return "pets/index";
    }
}
