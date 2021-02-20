package com.repositories;

import com.domain.Command;
import com.domain.linkTable.LinkCommandAndVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkVarAndComRepo extends JpaRepository<LinkCommandAndVariable, Long> {
}
