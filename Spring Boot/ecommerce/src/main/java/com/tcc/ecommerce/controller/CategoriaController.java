package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Categoria;
import com.tcc.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarCategoria(@RequestBody Categoria categoria) {
        repository.save(categoria);
    }

    @PutMapping("/alterar")
    public void alterarCategoria(@RequestBody Categoria categoria) {
        repository.save(categoria);
    }

    @GetMapping("/consultar/{codigoCategoria}")
    public Optional<Categoria> consultarCategoria(@PathVariable int codigoCategoria) {
        return repository.findById(codigoCategoria);
    }

    @GetMapping("/listar")
    public List<Categoria> listarCategoria() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{codigoCategoria}")
    public void excluirCategoria(@PathVariable int codigoCategoria) {
        repository.deleteById(codigoCategoria);
    }

}
