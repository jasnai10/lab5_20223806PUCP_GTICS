package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer id;

    @Column(name="nombre", length=50, nullable=false)
    private String nombre;

    @Column(name = "apellido", length=50, nullable=false)
    private String apellido;

    @Column(name = "correo", length=100, nullable=false)
    private String correo;

    @Column(name = "edad", nullable=false)
    private Integer edad;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "contrasena", length = 255)
    private String contrasena;


}
