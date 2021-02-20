package com.domain.linkTable;

import com.domain.Command;
import com.domain.ExecutentProgramm;

import javax.persistence.*;

@Entity
@Table(name = "link_command_and_programm")
public class LinkCommandAndProgramm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private String ident;

    private Long command_id;

    private Long program_id;

    public LinkCommandAndProgramm() {
    }

    public LinkCommandAndProgramm(boolean status, String ident, Long command_id, Long program_id) {
        this.status = status;
        this.ident = ident;
        this.command_id = command_id;
        this.program_id = program_id;
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

    public Long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Long command_id) {
        this.command_id = command_id;
    }

    public Long getProgram_id() {
        return program_id;
    }

    public void setProgram_id(Long program_id) {
        this.program_id = program_id;
    }
}
