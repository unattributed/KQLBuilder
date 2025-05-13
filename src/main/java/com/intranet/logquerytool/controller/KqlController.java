package com.intranet.logquerytool.controller;

import com.intranet.logquerytool.service.KqlQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KqlController {

    @Autowired
    private KqlQueryService kqlQueryService;

    @GetMapping("/query")
    public String showForm() {
        return "query"; // show the form
    }

    @PostMapping("/query")
    public String buildQuery(@RequestParam String cloud,
                             @RequestParam String logType,
                             @RequestParam(required = false) String filter,
                             Model model) {

        String kql = kqlQueryService.buildQuery(cloud, logType, filter);
        model.addAttribute("kqlQuery", kql);
        return "query"; // render same view with query
    }
}
// This controller handles the HTTP requests for building KQL queries.