package com.beneditorodrigo.webapi.controller;

import com.beneditorodrigo.webapi.model.Usuario;
import com.beneditorodrigo.webapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{username}")
    public Usuario buscarUsuario(@PathVariable String username){
        return usuarioRepository.findByUsername(username);
    }
}
