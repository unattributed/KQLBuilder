package com.intranet.logquerytool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/home")
    public String homePage(Model model) {
        return "home"; // resolves to templates/home.html
    }
}
// This controller handles the web interface for the KQLBuilder application.