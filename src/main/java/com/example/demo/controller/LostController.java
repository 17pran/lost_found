package com.example.demo.controller;

import com.example.demo.model.LostItem;
import com.example.demo.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LostController {

    @Autowired
    private LostItemRepository repo;

    @GetMapping("/lost")
    public String list(Model model) {
        model.addAttribute("view", "lostlist :: content");
        model.addAttribute("lostItems", repo.findAll());
        return "layout";
    }

    @GetMapping("/lost/add")
    public String lostForm(Model model) {
        model.addAttribute("view", "lostfrm :: content");
        return "layout";
    }

    @PostMapping("/lost/add")
    public String save(
            @RequestParam String itemName,
            @RequestParam String description,
            @RequestParam String location,
            @RequestParam String date
    ) {
        repo.save(new LostItem(itemName, description, location, date));
        return "redirect:/lost";
    }
}
