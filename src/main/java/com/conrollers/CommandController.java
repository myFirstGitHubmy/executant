package com.conrollers;

import com.domain.Command;
import com.domain.Variables;
import com.services.CommandService;
import com.services.VariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @Autowired
    private VariablesService variablesService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/addComm")
    public ResponseEntity<Command> addCommandByObject(@RequestBody Command command){
            ArrayList<Variables> newListVariables = new ArrayList<Variables>();
            newListVariables.add(variablesService.saveVariable(new Variables("",true)));
            Command newCommand = new Command(command.getName(), command.isStatus(), command.getIdent(), newListVariables, command.getProgram());
            Command commandNew = commandService.saveCommand(newCommand);
            return new ResponseEntity<Command>(commandNew, HttpStatus.OK);
    }

    @GetMapping("/command/{id}")
    public ResponseEntity<Command> getCommandByObject(@PathVariable("id") Long id){
        Command receivedCommand = commandService.getCommandById(id);
        return new ResponseEntity<Command>(receivedCommand, HttpStatus.OK);
    }
}
