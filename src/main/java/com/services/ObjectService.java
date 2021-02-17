package com.services;

import com.domain.ObjectMain;
import com.repositories.ObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ObjectService {
    @Autowired
    private ObjectRepo objectMain;

    public ObjectMain save (ObjectMain object){ ObjectMain obj = objectMain.save(object); return obj; }

    public Collection<ObjectMain> getAllObj(){ return objectMain.findAll(); }


}
