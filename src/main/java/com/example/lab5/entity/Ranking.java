package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id", nullable=false)
    private Integer id;

    @Column(name = "total_regalos")
    private Integer totalRegalos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalRegalos() {
        return totalRegalos;
    }

    public void setTotalRegalos(Integer totalRegalos) {
        this.totalRegalos = totalRegalos;
    }
}
