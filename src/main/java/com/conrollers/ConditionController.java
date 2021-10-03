package com.conrollers;

import com.domain.Condition;
import com.services.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/cond")
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Condition> addCondition(@RequestBody Condition condition){
        Condition newCondition = new Condition(condition.getName(),condition.getValue(), condition.getCommand_id(),true);
        conditionService.save(newCondition);
        return new ResponseEntity<Condition>(newCondition, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCondition(@PathVariable("id") Long id){
        conditionService.remove(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condition> getConditionById(@PathVariable("id") Long id){
        return new ResponseEntity<Condition>(conditionService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Condition>> getAll(){
        return new ResponseEntity<List<Condition>>(conditionService.getAll(),HttpStatus.OK);
    }
}
