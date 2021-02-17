package com.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "executent_programm")
public class ExecutentProgramm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private Collection<Command> commands_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private ObjectMain objectMain;

    public ExecutentProgramm() {
    }

    public ExecutentProgramm(Long id, String name, boolean status, Collection<Command> commands_id) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.commands_id = commands_id;
    }

    public ExecutentProgramm(String name, boolean status, Collection<Command> commands_id) {
        this.name = name;
        this.status = status;
        this.commands_id = commands_id;
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

    public Collection<Command> getCommands_id() {
        return commands_id;
    }

    public void setCommands_id(Collection<Command> commands_id) {
        this.commands_id = commands_id;
    }

    @Override
    public String toString() {
        return String.format("Execute: %d, %s, %s, %s", id, name, status, commands_id);
    }
}
