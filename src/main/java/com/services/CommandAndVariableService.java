package com.services;

import com.domain.linkTable.LinkCommandAndVariable;
import com.repositories.LinkVarAndComRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandAndVariableService {
    @Autowired
    private LinkVarAndComRepo linkVarAndComRepo;

    public CommandAndVariableService(LinkVarAndComRepo linkVarAndComRepo) {
        this.linkVarAndComRepo = linkVarAndComRepo;
    }

    public LinkCommandAndVariable getObjectById(Long id){
        return linkVarAndComRepo.getOne(id);
    }
}
