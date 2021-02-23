package com.services;

import com.domain.linkTable.LinkCommandAndVariable;
import com.repositories.LinkVarAndComRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandAndVariableService {
    @Autowired
    private final LinkVarAndComRepo linkVarAndComRepo;

    public CommandAndVariableService(LinkVarAndComRepo linkVarAndComRepo) {
        this.linkVarAndComRepo = linkVarAndComRepo;
    }

    public LinkCommandAndVariable save(LinkCommandAndVariable commandAndVariable) { return linkVarAndComRepo.save(commandAndVariable);}

    public LinkCommandAndVariable getObjectById(Long id){
        return linkVarAndComRepo.getOne(id);
    }

    public Long getIdOfCommand(Long id) { return linkVarAndComRepo.getByCommand_id(id); }

    public Long getIdOfVariable(Long id) { return linkVarAndComRepo.getByVariables_id(id); }
}
