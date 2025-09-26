package com.example.lab5.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "mensajes")
public class Mensajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer id;

    @Column(name = "regalo_tipo")
    private String regaloTipo;

    @Column(name = "regalo_color")
    private String regaloColor;

    @Column(name = "contenido", nullable=false, length=255)
    private String contenido;

    @Column(name = "fecha_envio")
    private Timestamp fechaEnvio;
}
