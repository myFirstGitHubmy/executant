package com.repositories;

import com.domain.ExecutentProgramm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutentRepo extends CrudRepository<ExecutentProgramm, Long> {
}
