package com.sally.app3.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter
    @Column(unique = true, nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(nullable = false)
    private String contrasena;


    public User() {}



}