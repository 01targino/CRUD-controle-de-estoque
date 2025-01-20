package com.controleDeEstoque.ControleDeEstoque.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListarProdutos(Long id, String nome, Integer quantidade, BigDecimal preco, Categoria categoria, String lote,
		LocalDate validade, Fornecedor fornecedor, boolean ativo) {
	
	public DadosListarProdutos(Produto produto) {
        this(produto.getId(), 
             produto.getNome(), 
             produto.getQuantidade(), 
             produto.getPreco(), 
             produto.getCategoria(), 
             produto.getLote(), 
             produto.getValidade(), 
             produto.getFornecedor(), 
             produto.isAtivo());
    }
	
	}
	
