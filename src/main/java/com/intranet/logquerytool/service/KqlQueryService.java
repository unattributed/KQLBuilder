package com.intranet.logquerytool.service;

import com.intranet.logquerytool.model.KqlQuery;
import com.intranet.logquerytool.repository.KqlQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KqlQueryService {

    private final KqlQueryRepository repository;

    @Autowired
    public KqlQueryService(KqlQueryRepository repository) {
        this.repository = repository;
    }

    public KqlQuery save(KqlQuery query) {
        return repository.save(query);
    }

    public Optional<KqlQuery> findById(Long id) {
        return repository.findById(id);
    }

    public Iterable<KqlQuery> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
