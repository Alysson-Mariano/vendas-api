package com.vendas.vendas_api.controller;

import com.vendas.vendas_api.model.Cliente;
import com.vendas.vendas_api.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    // Injeção de dependência via construtor (substitui o @Autowired e remove o aviso amarelo)
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Listar todos os clientes cadastrados (GET)
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Cadastrar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
}