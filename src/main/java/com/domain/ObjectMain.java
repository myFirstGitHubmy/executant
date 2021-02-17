package com.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "object")
public class ObjectMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ident;
    private boolean status;

    @OneToMany(mappedBy = "objectMain", cascade = CascadeType.ALL)
    private List<ExecutentProgramm> type_obj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ExecutentProgramm> getType_obj() {
        return type_obj;
    }

    public void setType_obj(List<ExecutentProgramm> type_obj) {
        this.type_obj = type_obj;
    }

    public ObjectMain() {
    }

    public ObjectMain(String name, String ident, boolean status, List<ExecutentProgramm> type_obj) {
        this.name = name;
        this.ident = ident;
        this.status = status;
        this.type_obj = type_obj;
    }

    public ObjectMain(String name) {
        this.name = name;
    }

    public ObjectMain(String name, String ident) {
        this.name = name;
        this.ident = ident;
    }


}
