package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Usuario;
import com.tcc.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarUsuario(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @PutMapping("/alterar")
    public void alterarUsuario(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @GetMapping("/consultar/{idUsuario}")
    public Optional<Usuario> consultarUsuario(@PathVariable int idUsuario) {
        return repository.findById(idUsuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{idUsuario}")
    public void excluirUsuario(@PathVariable int idUsuario) {
        repository.deleteById(idUsuario);
    }

}
