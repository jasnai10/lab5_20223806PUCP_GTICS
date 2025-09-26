package com.example.lab5.controller;

import com.example.lab5.entity.Ranking;
import com.example.lab5.entity.Usuario;
import com.example.lab5.repository.RankingRepository;
import com.example.lab5.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RankingController {

    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final int USER_FIXED = 1;

    // Mostrar el ranking de los usuarios
    @GetMapping("/ranking")
    public String showRanking(Model model) {
        Usuario usuarioLogueado = usuarioRepository.findById(USER_FIXED)
                .orElseThrow(() -> new IllegalArgumentException("Usuario fijo no encontrado"));

        List<Ranking> rankings = rankingRepository.findAll();
        rankings.sort((r1, r2) -> r2.getTotalRegalos().compareTo(r1.getTotalRegalos())); // Ordenar en orden descendente

        model.addAttribute("rankings", rankings);
        model.addAttribute("usuarioLogueado", usuarioLogueado);
        return "ranking";
    }
}
