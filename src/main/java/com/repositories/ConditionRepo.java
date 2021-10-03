package com.repositories;

import com.domain.Condition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepo extends CrudRepository<Condition, Long> {
    public Condition getById(Long id);
}
