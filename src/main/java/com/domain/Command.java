package com.domain;


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

    @Column(name = "NAME_VARIABLE")
    private String nameVariable;

    @Column(name = "VALUE_VARIABLE")
    private String valueVariable;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExecutentProgramm program;

    public Command() {
    }

    public Command(String name, boolean status, String ident, String nameVariable, String valueVariable) {
        this.name = name;
        this.status = status;
        this.ident = ident;
        this.nameVariable = nameVariable;
        this.valueVariable = valueVariable;
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

    public boolean getStatus() {
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

    public String getNameVariable() {
        return nameVariable;
    }

    public void setNameVariable(String nameVariable) {
        this.nameVariable = nameVariable;
    }

    public String getValueVariable() {
        return valueVariable;
    }

    public void setValueVariable(String valueVariable) {
        this.valueVariable = valueVariable;
    }


}
