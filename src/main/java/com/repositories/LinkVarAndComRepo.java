package com.repositories;

import com.domain.Command;
import com.domain.linkTable.LinkCommandAndVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Customizer;

@Repository
public interface LinkVarAndComRepo extends JpaRepository<LinkCommandAndVariable, Long>{

    @Query("select l.command_id from LinkCommandAndVariable l where l.id = :id_obj")
    public Long getByCommand_id(@Param("id_obj") Long id);

    @Query("select l.variables_id from LinkCommandAndVariable l where l.id = ?1")
    public Long getByVariables_id(Long id);
}
