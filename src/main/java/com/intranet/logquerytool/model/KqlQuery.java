package com.intranet.logquerytool.model;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class KqlQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cloud;
    private String logType;
    private String query;

    public KqlQuery() {}

    public KqlQuery(String cloud, String logType, String query) {
        this.cloud = cloud;
        this.logType = logType;
        this.query = query;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCloud() { return cloud; }
    public void setCloud(String cloud) { this.cloud = cloud; }

    public String getLogType() { return logType; }
    public void setLogType(String logType) { this.logType = logType; }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

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
