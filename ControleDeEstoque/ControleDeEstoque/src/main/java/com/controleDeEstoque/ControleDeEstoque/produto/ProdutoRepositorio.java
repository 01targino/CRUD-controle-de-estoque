package com.controleDeEstoque.ControleDeEstoque.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	List<Produto> findAllByAtivoTrue();

}
