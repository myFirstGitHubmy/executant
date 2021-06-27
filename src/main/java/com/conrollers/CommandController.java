package com.conrollers;

import com.domain.Command;
import com.services.CommandService;
import com.services.VariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/com")
public class CommandController {
    @Autowired
    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/add")
    public ResponseEntity<Command> addCommandByObject(@RequestBody Command command) {
        Command newCommand = new Command(command.getName(), command.isStatus(), command.getIdent());
        Command savedCom = commandService.save(newCommand);
        return new ResponseEntity<Command>(savedCom, HttpStatus.OK);
    }

    @GetMapping("/command/{id}")
    public ResponseEntity<Command> getCommandByObject(@PathVariable("id") Long id) {
        Command command = commandService.getById(id);
        return new ResponseEntity<Command>(command, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Command>> getAllCommands() {
        List<Command> getAllCom = commandService.getAll();
        return new ResponseEntity<List<Command>>(getAllCom, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<List<Command>> deleteCommand(@PathVariable("id") Long id) {
        commandService.removeById(id);
        List<Command> allCommands = commandService.getAll();
        return new ResponseEntity<List<Command>>(allCommands, HttpStatus.OK);
    }
}
