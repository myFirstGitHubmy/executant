package com.domain;


import com.domain.linkTable.LinkCommandAndVariable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private String ident;

//    @OneToMany(mappedBy = "commands",cascade = CascadeType.ALL)
//    private Collection<Variables> variables;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExecutentProgramm program;

    public Command() {
    }

    public Command(String name, boolean status, String ident, ExecutentProgramm program) {
        this.name = name;
        this.status = status;
        this.ident = ident;
        this.program = program;
    }

    public Command(String name, boolean status, String ident) {
        this.name = name;
        this.status = status;
        this.ident = ident;
    }



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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

//    public Collection<Variables> getVariables() {
//        return variables;
//    }
//
//    public void setVariables(Variables variables) {
//        this.variables.add(variables);
//    }

    public ExecutentProgramm getProgram() {
        return program;
    }

    public void setProgramm(ExecutentProgramm programm) {
        this.program = programm;
    }
}
