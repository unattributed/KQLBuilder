package com.intranet.logquerytool.controller;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.service.KqlQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KqlController {

    private final KqlQueryService service;

    public KqlController(KqlQueryService service) {
        this.service = service;
    }

    @GetMapping("/query")
    public String showForm(Model model) {
        model.addAttribute("kqlQuery", new KqlQuery());
        return "query";
    }

    @PostMapping("/query")
    public String submitForm(@ModelAttribute KqlQuery kqlQuery, Model model) {
        // Build a sample query string
        String query = String.format("// KQL for %s - %s\n| where %s",
                kqlQuery.getCloudProvider(), kqlQuery.getLogType(), kqlQuery.getFilter());

        kqlQuery.setQueryText(query);
        service.save(kqlQuery);

        model.addAttribute("kqlQuery", kqlQuery); // so query.html displays it

        return "query";
    }
}
