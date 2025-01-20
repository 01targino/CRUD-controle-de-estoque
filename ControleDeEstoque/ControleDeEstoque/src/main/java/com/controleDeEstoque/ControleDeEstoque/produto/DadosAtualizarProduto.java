package com.controleDeEstoque.ControleDeEstoque.produto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosAtualizarProduto(
		
		@NotNull
		Long id,
		
		String nome,
		
		Integer quantidade,
		
		@Positive
		BigDecimal preco
		
		) {
}
