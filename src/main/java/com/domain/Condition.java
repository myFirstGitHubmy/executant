package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "condition")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "value")
    String value;

    @Column(name = "command_id")
    Long command_id;

    @Column(name = "status")
    boolean status;

    public Condition() {
    }

    public Condition(String name, String value, Long command_id, boolean status) {
        this.name = name;
        this.value = value;
        this.command_id = command_id;
        this.status = status;
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
}
