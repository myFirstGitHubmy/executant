package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "Executent_programm")
public class ExecutentProgramm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean status;
}
