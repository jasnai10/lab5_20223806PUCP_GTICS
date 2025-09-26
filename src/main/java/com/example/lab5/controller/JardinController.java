package com.example.lab5.controller;

import com.example.lab5.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.lab5.repository.UsuarioRepository;

@Controller
public class JardinController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final int USER_FIXED = 1;

    // Mostrar la lista de usuarios en la página principal
    @GetMapping("/")
    public String showUsuarios(Model model) {
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("usuarioLogueado", usuarioLogueado);
        return "principal";
    }
}
