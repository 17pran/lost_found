package com.example.demo.controller;

import com.example.demo.model.FoundItem;
import com.example.demo.repository.FoundItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/found")
public class FoundController {

    @Autowired
    private FoundItemRepository repo;

    // List all found items
    @GetMapping
    public String list(Model model) {
        model.addAttribute("view", "foundlist :: content");
        model.addAttribute("foundItems", repo.findAll());
        return "layout";
    }

    // Show the form to add a found item
    @GetMapping("/add")
    public String foundForm(Model model) {
        model.addAttribute("view", "foundform :: content");
        model.addAttribute("foundItem", new FoundItem());
        return "layout";
    }

    // Handle form submission
    @PostMapping("/add")
    public String save(@ModelAttribute FoundItem foundItem, @RequestParam String date) {
        // Convert date string to LocalDate if FoundItem uses LocalDate
        foundItem.setDate(LocalDate.parse(date));
        repo.save(foundItem);
        return "redirect:/found";
    }
}
