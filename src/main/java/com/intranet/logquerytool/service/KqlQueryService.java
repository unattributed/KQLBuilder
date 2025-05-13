package com.intranet.logquerytool.service;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.repository.KqlQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service layer for managing KQL queries.
 */
@Service
public class KqlQueryService {

    private final KqlQueryRepository repository;

    @Autowired
    public KqlQueryService(KqlQueryRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a new KQL query to the database.
     *
     * @param query the KqlQuery object to save
     * @return the saved KqlQuery object
     */
    public KqlQuery save(KqlQuery query) {
        return repository.save(query);
    }

    /**
     * Find a KQL query by its ID.
     *
     * @param id the ID of the query
     * @return an Optional containing the found KqlQuery, or empty if not found
     */
    public Optional<KqlQuery> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Retrieve all saved KQL queries.
     *
     * @return an Iterable list of all KqlQuery objects
     */
    public Iterable<KqlQuery> findAll() {
        return repository.findAll();
    }

    /**
     * Delete a KQL query by its ID.
     *
     * @param id the ID of the query to delete
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
