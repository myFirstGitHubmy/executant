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

    public Command save(Command command){ return commandRepo.save(command); }

    public List<Command> getAll(){ return (List<Command>) commandRepo.findAll(); }

    public Command getById(Long id){ return commandRepo.getCommandById(id); }

    public void removeById(Long id){ commandRepo.deleteById(id); }
}
