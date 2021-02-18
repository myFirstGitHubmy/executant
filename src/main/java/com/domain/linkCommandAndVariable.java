package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "linkComandAndVariable")
public class linkCommandAndVariable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
