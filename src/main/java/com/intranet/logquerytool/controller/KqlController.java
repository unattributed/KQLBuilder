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
    public String home(Model model) {
        // Add the initial KQL query object to the model
        model.addAttribute("kqlQuery", new KqlQuery());
        return "query";  // This will render the query.html template
    }

    @PostMapping("/query")
    public String saveQuery(KqlQuery kqlQuery, Model model) {
        // Save the KQL query using the service
        KqlQuery savedQuery = kqlQueryService.save(kqlQuery);

        // Add the saved query to the model to display it on the page
        model.addAttribute("kqlQuery", savedQuery);
        return "query";  // This will render the query.html template again, displaying the saved query
    }
}
