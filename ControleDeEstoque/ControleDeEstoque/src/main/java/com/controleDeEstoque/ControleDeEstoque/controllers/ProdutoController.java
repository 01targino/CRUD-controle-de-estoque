package com.controleDeEstoque.ControleDeEstoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.controleDeEstoque.ControleDeEstoque.produto.DadosAdicionarProduto;
import com.controleDeEstoque.ControleDeEstoque.produto.DadosAtualizarProduto;
import com.controleDeEstoque.ControleDeEstoque.produto.DadosDetalhamentoProduto;
import com.controleDeEstoque.ControleDeEstoque.produto.DadosListarProdutos;
import com.controleDeEstoque.ControleDeEstoque.produto.Produto;
import com.controleDeEstoque.ControleDeEstoque.produto.ProdutoRepositorio;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepositorio repositorio;

	@PostMapping
	public ResponseEntity<DadosDetalhamentoProduto> adicionarProduto(@RequestBody @Valid DadosAdicionarProduto dados, UriComponentsBuilder uriBuilder) {
		var produto = new Produto(dados);
		repositorio.save(produto);
		
		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListarProdutos>> listarProdutos() {
		var lista = repositorio.findAllByAtivoTrue().stream().map(DadosListarProdutos::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoProduto> atualizarProduto(@RequestBody @Valid DadosAtualizarProduto dados) {
		var produto = repositorio.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> apagarProduto(@PathVariable Long id) {
		repositorio.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/desativar/{id}")
	@Transactional
	public ResponseEntity<Void> desativarProduto(@PathVariable Long id) {
		
		var produto = repositorio.getReferenceById(id);
		produto.desativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativarProduto(@PathVariable Long id) {
		
		var produto = repositorio.getReferenceById(id);
		
		produto.ativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoProduto> detalharProduto(@PathVariable Long id) {
		
		var produto = repositorio.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
	}
	
	
}
