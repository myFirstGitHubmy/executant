package com.repositories;

import com.domain.Variables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariablesRepo extends CrudRepository<Variables, Long> {
    public Variables getById(Long id);
}
