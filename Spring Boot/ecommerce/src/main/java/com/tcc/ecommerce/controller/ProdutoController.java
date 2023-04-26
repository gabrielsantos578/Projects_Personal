package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Produto;
import com.tcc.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarProduto(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @PutMapping("/alterar")
    public void alterarProduto(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @GetMapping("/consultar/{codigoProduto}")
    public Optional<Produto> consultarProduto(@PathVariable int codigoProduto) {
        return repository.findById(codigoProduto);
    }

    @GetMapping("/listar")
    public List<Produto> listarProduto() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{codigoProduto}")
    public void excluirProduto(@PathVariable int codigoProduto) {
        repository.deleteById(codigoProduto);
    }

}
