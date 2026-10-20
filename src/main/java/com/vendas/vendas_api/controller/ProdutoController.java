package com.vendas.vendas_api.controller;

import com.vendas.vendas_api.model.Produto;
import com.vendas.vendas_api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    // Injeção via construtor (recomendado pelo Spring)
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos os produtos (GET /produtos)
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // Cadastrar um novo produto (POST /produtos)
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}