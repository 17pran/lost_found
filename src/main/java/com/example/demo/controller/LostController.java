package com.example.demo.controller;

import com.example.demo.model.LostItem;
import com.example.demo.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class LostController {

    @Autowired
    private LostItemRepository repo;

    // Display all lost items
    @GetMapping("/lost")
    public String list(Model model) {
        model.addAttribute("view", "lostlist :: content"); // layout fragment
        model.addAttribute("lostItems", repo.findAll());
        return "layout";
    }

    // Show form to add lost item
    @GetMapping("/lost/add")
    public String lostForm(Model model) {
        model.addAttribute("view", "lostform :: content"); // make sure fragment name matches template
        return "layout";
    }

    // Save a new lost item
    @PostMapping("/lost/add")
    public String save(
            @RequestParam String itemName,
            @RequestParam String description,
            @RequestParam String location,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        LostItem lostItem = new LostItem(itemName, description, location, date);
        repo.save(lostItem);
        return "redirect:/lost";
    }
}
