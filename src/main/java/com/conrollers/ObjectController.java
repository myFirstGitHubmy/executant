package com.conrollers;

import com.domain.ObjectMain;
import com.services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ObjectController{
    @Autowired
    private ObjectService objectService;


    @PostMapping("/object")
    public ResponseEntity<ObjectMain> saveObj(@RequestBody ObjectMain object){
        ObjectMain obj = new ObjectMain(object.getName(), object.getIdent(),object.isStatus(),object.getType_obj());
            objectService.save(obj);
        return new ResponseEntity<ObjectMain>(obj, HttpStatus.OK);
    }
}
