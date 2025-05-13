package com.intranet.logquerytool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KqlController {

    @GetMapping("/query")
    public String queryPage(Model model) {
        model.addAttribute("message", "Build your query below:");
        return "query"; // renders query.html
    }
}
// This controller handles the web interface for the KQLBuilder application.