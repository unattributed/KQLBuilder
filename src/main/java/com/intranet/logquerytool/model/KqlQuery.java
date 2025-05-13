package com.intranet.logquerytool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kql_queries")
public class KqlQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cloud;
    private String logType;
    private String kql;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getKql() {
        return kql;
    }

    public void setKql(String kql) {
        this.kql = kql;
    }
}
// This class represents a KQL query entity in the database.
// It contains fields for the query ID, cloud provider, log type, and the KQL query itself.