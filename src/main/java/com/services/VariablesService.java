package com.services;

import com.domain.Variables;
import com.repositories.VariablesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource(value = "classpath:application.properties")
@Service
public class VariablesService {
    @Autowired
    private VariablesRepo variablesRepo;
    public Long getIdSavedVariable(Variables var){ return variablesRepo.save(var).getId(); }
    public Variables save(Variables var){ return variablesRepo.save(var); }
    public Variables getById(Long id){return variablesRepo.getById(id);}

    public List<Variables> getAll(){return (List<Variables>) variablesRepo.findAll();}

    public void removeById(Long id){ variablesRepo.deleteById(id); }
}
