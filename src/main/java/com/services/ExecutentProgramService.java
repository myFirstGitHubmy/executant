package com.services;

import com.domain.ExecutentProgramm;
import com.repositories.CommandRepo;
import com.repositories.ConditionRepo;
import com.repositories.ExecutentRepo;
import com.repositories.VariablesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutentProgramService {
    @Autowired
    private ExecutentRepo executentRepo;

    @Autowired
    private VariablesRepo variablesRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private CommandRepo commandRepo;

    public ExecutentProgramm save(ExecutentProgramm program) { return executentRepo.save(program); }

    public void removeAllCommand() { commandRepo.deleteAll(); }

    public void removeAllVariables() { variablesRepo.deleteAll(); }

    public void removeAllCondition() { conditionRepo.deleteAll();}
}
