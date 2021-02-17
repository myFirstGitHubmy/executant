package com.repositories;

import com.domain.ObjectMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepo extends JpaRepository<ObjectMain, Long> {
}
