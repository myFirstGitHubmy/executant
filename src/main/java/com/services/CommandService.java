package com.services;

import com.domain.Command;
import com.repositories.CommandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepo commandRepo;

    public Command saveCommand(Command command){ return commandRepo.save(command); }

    public List<Command> getAllCommand(){ return (List<Command>) commandRepo.findAll(); }

    public Command getCommandById(Long id){ return commandRepo.getCommandById(id); }
}
