package com.conrollers;

import com.domain.Variables;
import com.services.CommandService;
import com.services.VariablesService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/var")
public class VariablesController {
    @Autowired
    private final VariablesService variablesService;

    public VariablesController(VariablesService variablesService) {
        this.variablesService = variablesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Variables> addVariablesByObject(@RequestBody Variables var) {
        Variables newVar = new Variables(var.getName(), var.getValue(), true);
        Variables varSaved = variablesService.save(newVar);
        return new ResponseEntity<Variables>(varSaved, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Variables> updateVariableById(@RequestBody Variables variables) {
        Variables variableByIdById = variablesService.getById(variables.getId());
        variableByIdById.setValue(variables.getValue());
        variableByIdById.setValue(variables.getName());
        variablesService.save(variableByIdById);
        return new ResponseEntity<Variables>(variableByIdById, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variables> getVariable(@PathVariable("id") Long id) {
        Variables receivedVar = variablesService.getById(id);
        return new ResponseEntity<Variables>(receivedVar, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Variables>> getAllVariables() {
        List<Variables> allVar = variablesService.getAll();
        return new ResponseEntity<List<Variables>>(allVar, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<List<Variables>> removeVariableById(@PathVariable("id") Long id) {
        variablesService.removeById(id);
        List<Variables> allVars = variablesService.getAll();
        return new ResponseEntity<List<Variables>>(allVars, HttpStatus.OK);
    }
}
