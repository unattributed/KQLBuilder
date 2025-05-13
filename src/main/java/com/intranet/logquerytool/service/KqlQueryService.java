package com.intranet.logquerytool.service;

import org.springframework.stereotype.Service;

@Service
public class KqlQueryService {

    public String buildQuery(String cloud, String logType, String filter) {
        String table;

        switch (cloud.toLowerCase()) {
            case "azure":
                table = "AzureDiagnostics";
                break;
            case "aws":
                table = "AWSEvents";
                break;
            case "gcp":
                table = "GCPLogs";
                break;
            default:
                table = "UnknownLogs";
        }

        StringBuilder query = new StringBuilder();
        query.append(table);

        if (logType != null && !logType.isEmpty()) {
            query.append(" | where LogType == '").append(logType).append("'");
        }

        if (filter != null && !filter.isBlank()) {
            query.append(" | where ").append(filter);
        }

        query.append(" | take 100");

        return query.toString();
    }
}
// This service class is responsible for building KQL queries based on user input.