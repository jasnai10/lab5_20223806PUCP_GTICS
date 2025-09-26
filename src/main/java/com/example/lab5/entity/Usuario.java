
package com.example.lab5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer id;

    @NotBlank(message="El nombre no puede estar vacío")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "El nombre solo debe contener letras.")
    @Size(max=50, message = "El nombre no puede tener más de 50 caracteres")
    @Column(name="nombre", length=50, nullable=false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "El apellido solo debe contener letras.")
    @Size(max=50, message = "El apellido no puede tener más de 50 caracteres")
    @Column(name = "apellido", length=50, nullable=false)
    private String apellido;

    @Email(message = "El correo no es válido")
    @Size(max = 100, message = "El correo no debe tener más de 100 caracteres")
    @Column(name = "correo", length=100, nullable=false)
    private String correo;

    @Positive(message = "La edad tiene que ser un número positivo")
    @Min(value = 18, message = "La edad mínima es 18 años.")
    @Column(name = "edad", nullable=false)
    private Integer edad;

    @Size(min = 10, message = "La descripcion debe ser como mínimo 10 caracteres")
    @Size(max = 255, message = "La descripción no debe tener más de 255 caracteres")
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Size(max = 255, message = "La contraseña no debe tener más de 255 caracteres")
    @Pattern(regexp = "^(?=.*\\d).{6,}$", message = "La contraseña debe tener al menos 6 caracteres y contener al menos un número.")
    @Column(name = "contrasena", length = 255)
    private String contrasena;

    @OneToMany(mappedBy = "remitente")
    private List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "destinatario")
    private List<Mensaje> mensajesRecibidos;

    @OneToOne(mappedBy = "usuario")
    private Ranking ranking;


    //Añadir constructores
    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String correo, Integer edad, String descripcion, String contrasena) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setEdad(edad);
        this.setDescripcion(descripcion);
        this.setContrasena(contrasena);
    }

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

    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
}
