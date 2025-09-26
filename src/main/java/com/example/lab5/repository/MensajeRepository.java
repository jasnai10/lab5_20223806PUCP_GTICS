package com.example.lab5.repository;

import com.example.lab5.entity.Mensaje;
import com.example.lab5.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    List<Mensaje> findByDestinatario(Usuario destinatario);
}
