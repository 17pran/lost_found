package com.example.demo.controller;

import com.example.demo.model.FoundItem;
import com.example.demo.repository.FoundItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoundController {

    @Autowired
    private FoundItemRepository repo;

    @GetMapping("/found")
    public String list(Model model) {
        model.addAttribute("view", "foundlist :: content");
        model.addAttribute("foundItems", repo.findAll());
        return "layout";
    }

    @GetMapping("/found/add")
    public String foundForm(Model model) {
        model.addAttribute("view", "foundform :: content");
        return "layout";
    }

    @PostMapping("/found/add")
    public String save(
            @RequestParam String itemName,
            @RequestParam String description,
            @RequestParam String location,
            @RequestParam String date
    ) {
        repo.save(new FoundItem(itemName, description, location, date));
        return "redirect:/found";
    }
}
