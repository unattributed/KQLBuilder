package com.intranet.logquerytool.controller;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.service.KqlQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KqlController {

    private final KqlQueryService service;

    @Autowired
    public KqlController(KqlQueryService service) {
        this.service = service;
    }

    @GetMapping("/query")
    public String showQueryForm(Model model) {
        return "query";
    }

    @PostMapping("/query")
    public String buildAndSaveQuery(
            @RequestParam String cloud,
            @RequestParam String logType,
            @RequestParam(required = false) String filter,
            Model model
    ) {
        String kql = buildKql(cloud, logType, filter);

        KqlQuery query = new KqlQuery();
        query.setCloud(cloud);
        query.setLogType(logType);
        query.setFilter(filter);
        query.setKql(kql);

        service.save(query);
        model.addAttribute("kqlQuery", kql);
        return "query";
    }

    private String buildKql(String cloud, String logType, String filter) {
        StringBuilder sb = new StringBuilder();
        sb.append(logType);
        if (filter != null && !filter.isEmpty()) {
            sb.append(" | where ").append(filter);
        }
        sb.append(" | project TimeGenerated, ResourceId, OperationName");
        return sb.toString();
    }
}
