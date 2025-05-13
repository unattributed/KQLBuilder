package com.intranet.logquerytool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KqlController {

    @GetMapping("/query")
    public String queryPage() {
        return "query"; // Loads the form
    }

    @PostMapping("/query")
    public String processQuery(
            @RequestParam("cloud") String cloud,
            @RequestParam("logType") String logType,
            @RequestParam("keyword") String keyword,
            Model model) {

        // Simple mock KQL generation
        String kql = String.format("Cloud: %s | LogType: %s | Search: %s", cloud, logType, keyword);

        model.addAttribute("kqlQuery", kql);
        return "query"; // Reload same page with result
    }
}
 // Note: In a real application, you would replace the mock KQL generation with actual logic to generate KQL queries based on the inputs.