package com.intranet.logquerytool.repository;

import com.intranet.logquerytool.model.KqlQuery;
import org.springframework.data.repository.CrudRepository;

public interface KqlQueryRepository extends CrudRepository<KqlQuery, Long> {
}
