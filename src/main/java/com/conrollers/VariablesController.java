package com.conrollers;

import com.domain.Variables;
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
    private VariablesService variablesService;

    @Autowired
    private CommandService commandService;

    public VariablesController(VariablesService variablesService) {
        this.variablesService = variablesService;
    }

    @PostMapping("/add_var")
    public ResponseEntity<Variables> addVariablesByObject(@RequestBody Variables var){

        List<Variables> allVariables = variablesService.getAllVariables();
        Variables newVar = null;
//        for (Variables pair:allVariables) {
//            if (pair.getName().equals(var.getName())){
//                newVar=pair;
//            }
//        }
//        if (newVar == null){
            newVar = new Variables(var.getName(),var.getValue(),var.isStatus(),commandService.getCommandById(var.getId()));
            Variables varSaved = variablesService.saveVariable(newVar);
            return new ResponseEntity<Variables>(varSaved, HttpStatus.OK);
//        }else{
//            Variables varResave = newVar;
//            if (var.getValue()!=null&&!var.getValue().equals(varResave.getValue())) {
//                varResave.setValue(var.getValue());
//                variablesService.addVariable(newVar);
//            }
//            return new ResponseEntity<Variables>(varResave, HttpStatus.FOUND);
//        }

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
}
