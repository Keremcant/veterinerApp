package com.example.veterinerApp.controller;

import com.example.veterinerApp.service.OwnerService;
import com.example.veterinerApp.service.PetService;
import com.example.veterinerApp.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("ownerCount", ownerService.count());
        model.addAttribute("petCount", petService.count());
        return "home";
    }
}
