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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegaloTipo() {
        return regaloTipo;
    }

    public void setRegaloTipo(String regaloTipo) {
        this.regaloTipo = regaloTipo;
    }

    public String getRegaloColor() {
        return regaloColor;
    }

    public void setRegaloColor(String regaloColor) {
        this.regaloColor = regaloColor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
