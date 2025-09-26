package com.example.lab5.controller;

import com.example.lab5.entity.Usuario;
import com.example.lab5.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.constraints.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final int USER_FIXED = 1;

    @GetMapping("/registro")
    public String showRegistroForm(Model model) {
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarioLogueado", usuarioLogueado);
        return "registro";
    }

    @PostMapping("/registro")
    public String registerUsuario(@Valid Usuario usuario, BindingResult result, Model model) {
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));
        if (result.hasErrors()) {
            return "registro";
        }
        usuarioRepository.save(usuario);
        model.addAttribute("usuarioLogueado", usuarioLogueado);
        return "redirect:/";  // Redirige a la página principal después de registrar
    }
}
