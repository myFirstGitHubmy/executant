package com.services;

import com.domain.Command;
import com.domain.Condition;
import com.repositories.ConditionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {
    @Autowired
    private ConditionRepo conditionRepo;

    public Condition save(Condition condition){
       return conditionRepo.save(condition);
    }

    public void remove(Long id ){
        conditionRepo.deleteById(id);
    }

    public Condition getById(Long id){
        return conditionRepo.getById(id);
    }

    public List<Condition> getAll(){
        return (List<Condition>) conditionRepo.findAll();
    }
}
