package com.conrollers;

import com.domain.ExecutentProgramm;
import com.services.ExecutentProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ExecutentController {
    @Autowired
    private ExecutentProgramService executentProgramService;

    @PostMapping("/program")
    public ResponseEntity<ExecutentProgramm> saveProgram(@RequestBody ExecutentProgramm program){
        ExecutentProgramm executentProgramm = new ExecutentProgramm(program.getName(),program.isStatus(),program.getCommands_id());
        executentProgramService.save(executentProgramm);
        return new ResponseEntity<ExecutentProgramm>(executentProgramm, HttpStatus.OK);
    }
}
