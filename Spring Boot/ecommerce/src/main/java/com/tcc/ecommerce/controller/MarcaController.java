package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Marca;
import com.tcc.ecommerce.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarMarca(@RequestBody Marca marca) {
        repository.save(marca);
    }

    @PutMapping("/alterar")
    public void alterarMarca(@RequestBody Marca marca) {
        repository.save(marca);
    }

    @GetMapping("/consultar/{codigoMarca}")
    public Optional<Marca> consultarMarca(@PathVariable int codigoMarca) {
        return repository.findById(codigoMarca);
    }

    @GetMapping("/listar")
    public List<Marca> listarMarca() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{codigoMarca}")
    public void excluirMarca(@PathVariable int codigoMarca) {
        repository.deleteById(codigoMarca);
    }
}
