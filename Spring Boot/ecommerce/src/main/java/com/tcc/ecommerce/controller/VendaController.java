package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Venda;
import com.tcc.ecommerce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarVenda(@RequestBody Venda venda) {
        repository.save(venda);
    }

    @PutMapping("/alterar")
    public void alterarVenda(@RequestBody Venda venda) {
        repository.save(venda);
    }

    @GetMapping("/consultar/{codigoVenda}")
    public Optional<Venda> consultarVenda(@PathVariable int codigoVenda) {
        return repository.findById(codigoVenda);
    }

    @GetMapping("/listar")
    public List<Venda> listarVenda() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{codigoVenda}")
    public void excluirVenda(@PathVariable int codigoVenda) {
        repository.deleteById(codigoVenda);
    }

}
