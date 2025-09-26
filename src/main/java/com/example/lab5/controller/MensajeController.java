package com.example.lab5.controller;

import com.example.lab5.entity.Mensaje;
import com.example.lab5.entity.Usuario;
import com.example.lab5.repository.MensajeRepository;
import com.example.lab5.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class MensajeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MensajeRepository mensajeRepository;

    // Usuario estático con id = 1
    private static final int USER_FIXED = 1;

    // Mostrar el formulario para enviar un mensaje
    @GetMapping("/mensaje")
    public String showMensajeForm(Model model) {
        // Buscar el usuario fijo en la base de datos
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));

        model.addAttribute("remitente", usuarioLogueado);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("mensaje", new Mensaje());

        return "mensaje"; // Vista que contendrá el formulario
    }

    // Enviar el mensaje
    @PostMapping("/mensaje")
    public String sendMensaje(Mensaje mensaje) {
        // Usar siempre el usuario fijo
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));

        mensaje.setRemitente(usuarioLogueado);
        mensaje.setFechaEnvio(new Timestamp(System.currentTimeMillis()));

        mensajeRepository.save(mensaje);

        return "redirect:/";
    }

    @GetMapping("/mensajes-recibidos")
    public String showMensajesRecibidos(Model model) {
        // Buscar el usuario con id = 1
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));

        // Obtener todos los mensajes recibidos por el usuario
        List<Mensaje> mensajesRecibidos = mensajeRepository.findByDestinatario(usuarioLogueado);

        // Contar la cantidad total de mensajes recibidos
        int totalMensajes = mensajesRecibidos.size();

        model.addAttribute("mensajes", mensajesRecibidos);
        model.addAttribute("usuario", usuarioLogueado);
        model.addAttribute("totalMensajes", totalMensajes); // Mostrar el total de mensajes recibidos

        return "mensajes-recibidos"; // Vista que mostrará los mensajes recibidos
    }
}
