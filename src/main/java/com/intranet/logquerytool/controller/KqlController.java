package com.intranet.logquerytool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KqlController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to KQLBuilder Web UI");
        return "index"; // resolves to templates/index.html
    }
}
