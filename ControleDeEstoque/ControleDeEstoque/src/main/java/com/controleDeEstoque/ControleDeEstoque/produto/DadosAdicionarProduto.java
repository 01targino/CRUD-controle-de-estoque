package com.controleDeEstoque.ControleDeEstoque.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosAdicionarProduto(
		
		@NotBlank
		String nome,
		
		Integer quantidade,
		
		@Positive
		BigDecimal preco,
		
		@Enumerated
		Categoria categoria,
		
		String lote,
		
		@Future
		LocalDate validade,
		
		@Enumerated
		Fornecedor fornecedor,
		
		boolean ativo
		
		) {


}
