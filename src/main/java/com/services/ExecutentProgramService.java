package com.services;

import com.domain.ExecutentProgramm;
import com.repositories.ExecutentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutentProgramService {
    @Autowired
    private ExecutentRepo executentRepo;

    public ExecutentProgramm save(ExecutentProgramm program) { return executentRepo.save(program); }
}
