package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("view", "index :: content");
        return "layout";
    }
}
