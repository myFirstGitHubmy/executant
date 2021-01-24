package com.domain;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table(name = "Variables")
public class Variables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value_var;

    @Column(nullable = false)
    private boolean status;


}
