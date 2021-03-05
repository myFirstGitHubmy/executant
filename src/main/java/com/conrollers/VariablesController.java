package com.conrollers;

import com.domain.Variables;
import com.services.CommandAndVariableService;
import com.services.CommandService;
import com.services.VariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class VariablesController {
    @Autowired
    private final VariablesService variablesService;

    @Autowired
    private CommandService commandService;

    @Autowired
    private CommandAndVariableService commandAndVariableService;

    public VariablesController(VariablesService variablesService) {
        this.variablesService = variablesService;
    }

    @PostMapping("/add_var")
    public ResponseEntity<Variables> addVariablesByObject(@RequestBody Variables var){
            Variables newVar = new Variables(var.getName(),var.getValue(),true);
            Variables varSaved = variablesService.saveVariable(newVar);
        return new ResponseEntity<Variables>(varSaved, HttpStatus.OK);
    }

    @PostMapping("/update/var")
    public ResponseEntity<Variables> updateVariableById(@RequestBody Variables variables){
        Variables variableByIdById = variablesService.getVariableById(variables.getId());
            variableByIdById.setValue(variables.getValue());
            variableByIdById.setValue(variables.getName());
        variablesService.saveVariable(variableByIdById);
        return new ResponseEntity<Variables>(variableByIdById, HttpStatus.OK);
    }

    @GetMapping("/var/{id}")
    public ResponseEntity<Variables> getVariable(@PathVariable("id") Long id){
        Variables receivedVar = variablesService.getVariableById(id);
        return new ResponseEntity<Variables>(receivedVar, HttpStatus.OK);
    }

    @GetMapping("/allVars")
    public ResponseEntity<List<Variables>> getAllVariables(){
        List<Variables> allVar = variablesService.getAllVariables();
        return new ResponseEntity<List<Variables>>(allVar, HttpStatus.OK);
    }

    @GetMapping("/var/delete/{id}")
    public void  removeVariableById(@PathVariable("id") Long id){
        variablesService.removeVariable(id);
    }
}
