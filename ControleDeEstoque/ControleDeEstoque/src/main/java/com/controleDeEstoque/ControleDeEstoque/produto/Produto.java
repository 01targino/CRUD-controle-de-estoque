package com.controleDeEstoque.ControleDeEstoque.produto;

import java.math.BigDecimal;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "produtos")
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Produto {
		
	public Produto(@Valid DadosAdicionarProduto dados) {
		this.nome = dados.nome();
		this.quantidade = dados.quantidade();
		this.preco = dados.preco();
		this.categoria = dados.categoria();
		this.lote = dados.lote();
		this.validade = dados.validade();
		this.fornecedor = dados.fornecedor();
		this.ativo = true;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer quantidade;
	
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private String lote;
	
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING)
	private Fornecedor fornecedor;
	
	private boolean ativo;

	public void atualizarInformacoes(@Valid DadosAtualizarProduto dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.quantidade() != null) {
			this.quantidade = dados.quantidade();
		}
		
		if(dados.preco() != null) {
			this.preco = dados.preco();
		}
	}

	public void desativar() {
		this.ativo = false;
	}

	public void ativar() {
		this.ativo = true;
		
	}

}
