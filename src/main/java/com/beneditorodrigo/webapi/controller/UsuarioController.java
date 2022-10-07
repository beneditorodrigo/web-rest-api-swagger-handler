package com.beneditorodrigo.webapi.controller;

import com.beneditorodrigo.webapi.model.Usuario;
import com.beneditorodrigo.webapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/usuarios/{id}")
    public void excluirUsuario(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
    }

    @PostMapping("/usuarios")
    public void adcionarUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
