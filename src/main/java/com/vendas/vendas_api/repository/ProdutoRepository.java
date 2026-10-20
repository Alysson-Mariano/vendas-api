package com.vendas.vendas_api.repository;

import com.vendas.vendas_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}