package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "variables")
public class Variables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String value;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Command commands;

    public Variables() {
    }

    public Variables(String name, String value, boolean status, Command commands) {
        this.name = name;
        this.value = value;
        this.status = status;
        this.commands = commands;
    }

    public Variables(String name, String value, boolean status) {
        this.name = name;
        this.value = value;
        this.status = status;
    }

    public Variables(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public Variables(boolean status) {
        this.status = status;
    }

    public Variables(String name, boolean status, Command commands) {
        this.name = name;
        this.status = status;
        this.commands = commands;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Command getCommands() {
        return commands;
    }

    public void setCommands(Command commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return String.format("Var[id: %d, name: %s, value: %s, status: %b, command_id: %d]", id, name, value, status, commands.getId());
    }
}
