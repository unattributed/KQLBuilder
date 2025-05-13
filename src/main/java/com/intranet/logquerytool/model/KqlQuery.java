package com.intranet.logquerytool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KqlQuery {

    // The primary key column with auto-generated value handled by SQLite
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SQLite key generation strategy
    private Long id;

    // Field for the cloud provider (e.g., Azure, AWS, GCP)
    private String cloud;

    // Field for the type of logs (e.g., Activity Logs, CloudTrail)
    private String logType;

    // Field for the KQL query string
    private String query;

    // Default constructor
    public KqlQuery() {
    }

    // Constructor to initialize all fields
    public KqlQuery(String cloud, String logType, String query) {
        this.cloud = cloud;
        this.logType = logType;
        this.query = query;
    }

    // Getter and Setter for the id field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for the cloud field
    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    // Getter and Setter for the logType field
    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    // Getter and Setter for the query field
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "KqlQuery{" +
               "id=" + id +
               ", cloud='" + cloud + '\'' +
               ", logType='" + logType + '\'' +
               ", query='" + query + '\'' +
               '}';
    }
}
// This class represents a KQL query entity with fields for cloud provider, log type, and the query string.
// It includes constructors, getters, setters, and a toString method for easy representation.
// The class is annotated with @Entity to indicate that it is a JPA entity and will be mapped to a database table.