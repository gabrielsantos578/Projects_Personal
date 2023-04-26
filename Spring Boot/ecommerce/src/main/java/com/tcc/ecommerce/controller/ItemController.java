package com.tcc.ecommerce.controller;

import com.tcc.ecommerce.model.Item;
import com.tcc.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrarItem(@RequestBody Item item) {
        repository.save(item);
    }

    @PutMapping("/alterar")
    public void alterarItem(@RequestBody Item item) {
        repository.save(item);
    }

    @GetMapping("/consultar/{idItem}")
    public Optional<Item> consultarItem(@PathVariable int idItem) {
        return repository.findById(idItem);
    }

    @GetMapping("/listar")
    public List<Item> listarItem() {
        return repository.findAll();
    }

    @DeleteMapping("/excluir/{idItem}")
    public void excluirItem(@PathVariable int idItem) {
        repository.deleteById(idItem);
    }

}
