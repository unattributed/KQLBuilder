package com.intranet.logquerytool.controller;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.service.KqlQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/query")
public class KqlController {

    private final KqlQueryService service;

    @Autowired
    public KqlController(KqlQueryService service) {
        this.service = service;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("kqlQuery", new KqlQuery());
        model.addAttribute("queries", service.findAll());
        return "query"; // resolves to templates/query.html
    }

    @PostMapping
    public String submitQuery(@ModelAttribute KqlQuery kqlQuery, Model model) {
        service.save(kqlQuery);
        model.addAttribute("kqlQuery", new KqlQuery());
        model.addAttribute("queries", service.findAll());
        return "query";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuery(@PathVariable Long id, Model model) {
        service.deleteById(id);
        model.addAttribute("kqlQuery", new KqlQuery());
        model.addAttribute("queries", service.findAll());
        return "query";
    }
    @GetMapping("/saved")
    public String viewSavedQueries(Model model) {
        Iterable<KqlQuery> queries = service.findAll();
        model.addAttribute("queries", queries);
        return "saved"; // resolves to saved.html
    }
}
