package com.intranet.logquerytool.service;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.repository.KqlQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KqlQueryService {

    private final KqlQueryRepository repository;

    public KqlQueryService(KqlQueryRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a new KQL query to the database.
     * @param query the KqlQuery object to save
     */
    public void save(KqlQuery query) {
        repository.save(query);
    }

    /**
     * Get a specific query by ID.
     * @param id the ID of the query
     * @return the KqlQuery object if found
     */
    public Optional<KqlQuery> getById(Long id) {
        return repository.findById(id);
    }

    /**
     * Retrieve all saved KQL queries.
     * @return a list of all queries
     */
    public List<KqlQuery> getAllQueries() {
        return (List<KqlQuery>) repository.findAll();
    }

    /**
     * Delete a query by ID.
     * @param id the ID of the query to delete
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
