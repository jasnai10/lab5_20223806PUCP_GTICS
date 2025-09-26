package com.example.lab5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "regalo_tipo")
    private RegaloTipo regaloTipo;

    @Column(name = "regalo_color", length = 30)
    private String regaloColor;

    @Size(min = 20, message = "El mensaje debe ser como mínimo 20 caracteres")
    @Column(name = "contenido", nullable=false, length=255)
    private String contenido;

    @Column(name = "fecha_envio")
    private Timestamp fechaEnvio;

    @ManyToOne
    @JoinColumn(name="remitente_id", nullable = false)
    private Usuario remitente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private Usuario destinatario;

    public Mensaje(){}

    public Mensaje(Integer id, RegaloTipo regaloTipo, String regaloColor, String contenido, Timestamp fechaEnvio, Usuario remitente, Usuario destinatario) {
        this.setId(id);
        this.setRegaloTipo(regaloTipo);
        this.setRegaloColor(regaloColor);
        this.setContenido(contenido);
        this.setFechaEnvio(fechaEnvio);
        this.setRemitente(remitente);
        this.setDestinatario(destinatario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegaloTipo getRegaloTipo() {
        return regaloTipo;
    }

    public void setRegaloTipo(RegaloTipo regaloTipo) {
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

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public enum RegaloTipo {
        FLOR, CARRITO
    }
}