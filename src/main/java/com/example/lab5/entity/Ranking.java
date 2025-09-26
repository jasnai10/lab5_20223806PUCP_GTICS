package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Agregamos un ID auto-generado
    @Column(name = "id", nullable = false)
    private Integer id;  // Campo ID explícito

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;  // Relación con Usuario

    @Column(name = "total_regalos", nullable = false)
    private Integer totalRegalos;

    // Constructor por defecto
    public Ranking() {
    }

    // Constructor con parámetros
    public Ranking(Usuario usuario, Integer totalRegalos) {
        this.usuario = usuario;
        this.totalRegalos = totalRegalos;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTotalRegalos() {
        return totalRegalos;
    }

    public void setTotalRegalos(Integer totalRegalos) {
        this.totalRegalos = totalRegalos;
    }
}
