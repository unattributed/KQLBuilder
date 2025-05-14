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

    private String cloudProvider;
    private String logSource;
    private String table;
    private String field;
    private String operator;
    private String value;
    private String generatedQuery;

    public KqlQuery() {}

    public KqlQuery(String cloudProvider, String logSource, String table, String field, String operator, String value, String generatedQuery) {
        this.cloudProvider = cloudProvider;
        this.logSource = logSource;
        this.table = table;
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.generatedQuery = generatedQuery;
    }

    public Long getId() {
        return id;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getLogSource() {
        return logSource;
    }

    public void setLogSource(String logSource) {
        this.logSource = logSource;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGeneratedQuery() {
        return generatedQuery;
    }

    public void setGeneratedQuery(String generatedQuery) {
        this.generatedQuery = generatedQuery;
    }
}
