package com.domain.linkTable;

import com.domain.Command;
import com.domain.Variables;

import javax.persistence.*;

@Entity
@Table(name = "linkComandAndVariable")
public class LinkCommandAndVariable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long variables_id;

    private Long command_id;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private String ident;

    public LinkCommandAndVariable() {
    }

    public LinkCommandAndVariable(Long variables_id, Long command_id, boolean status, String ident) {
        this.variables_id = variables_id;
        this.command_id = command_id;
        this.status = status;
        this.ident = ident;
    }

    public Long getVariables_id() {
        return variables_id;
    }

    public void setVariables_id(Long variables_id) {
        this.variables_id = variables_id;
    }

    public Long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Long command_id) {
        this.command_id = command_id;
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
}
