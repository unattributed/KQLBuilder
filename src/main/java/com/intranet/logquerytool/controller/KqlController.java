package com.intranet.logquerytool.controller;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.service.KqlQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KqlController {

    private final KqlQueryService kqlQueryService;

    @Autowired
    public KqlController(KqlQueryService kqlQueryService) {
        this.kqlQueryService = kqlQueryService;
    }

    @GetMapping("/query")
    public String showQueryForm(Model model) {
        model.addAttribute("kqlQuery", new KqlQuery());
        return "query"; // Ensure this matches the name of your template (query.html)
    }

    @PostMapping("/query")
    public String generateKqlQuery(KqlQuery kqlQuery, Model model) {
        kqlQueryService.save(kqlQuery);
        model.addAttribute("message", "KQL Query Saved Successfully!");
        model.addAttribute("kqlQuery", kqlQuery);
        return "query";
    }

    @GetMapping("/queries")
    public String showSavedQueries(Model model) {
        model.addAttribute("queries", kqlQueryService.findAll());
        return "queries"; // Ensure this matches the name of your template (queries.html)
    }
}
