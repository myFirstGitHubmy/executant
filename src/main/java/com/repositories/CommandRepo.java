package com.repositories;

import com.domain.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepo extends CrudRepository<Command, Long> {
    public Command getCommandById(Long id);
}
