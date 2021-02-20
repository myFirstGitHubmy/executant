package com.repositories;

import com.domain.linkTable.LinkCommandAndProgramm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkComAndProgRepo extends JpaRepository<LinkCommandAndProgramm, Long> {
}
