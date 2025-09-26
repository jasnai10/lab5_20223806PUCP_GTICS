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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
