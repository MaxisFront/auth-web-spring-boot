package com.sally.app4.Controller;

import com.sally.app4.Model.Usuario;
import com.sally.app4.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pagesController {
    @GetMapping("/uwu")
    public String retornarIndex() {
        return "forward:/index.html";
    }
    @Autowired
    private UsuarioRepository usuarioRepository;



    @PostMapping("/login")
    public String procesarLogin(@RequestParam("nombre") String nombre,
                                @RequestParam("contrasena") String contrasena) {
        Usuario usuario = usuarioRepository.findByNombre(nombre);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return "redirect:/admin.html";
        } else {
            return "redirect:/?error";
        }
    }
}