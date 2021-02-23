package com.conrollers;

import com.domain.Command;
import com.domain.Variables;
import com.domain.linkTable.LinkCommandAndVariable;
import com.services.CommandAndVariableService;
import com.services.CommandService;
import com.services.VariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class LinkCommandAndVariableController {
    @Autowired
    private CommandAndVariableService commandAndVariableService;

    @Autowired
    private CommandService commandService;

    @Autowired
    private VariablesService variablesService;

    @PostMapping("add/requestAssign")
    public ResponseEntity<Variables> addLinkCommandAndVariableRequest(@RequestBody Variables var, @RequestBody Command command){
        Command com = new Command(command.getName(), command.isStatus(), command.getIdent());
            commandService.saveCommand(com);
        Variables variables = new Variables(var.getName(),var.getValue(),var.isStatus());
            variablesService.saveVariable(variables);
        LinkCommandAndVariable object = new LinkCommandAndVariable(com.getId(), variables.getId(), true, "REQ_COM_AND_VAR");
            commandAndVariableService.save(object);
        return new ResponseEntity<Variables>(variables, HttpStatus.OK);
    }
}
