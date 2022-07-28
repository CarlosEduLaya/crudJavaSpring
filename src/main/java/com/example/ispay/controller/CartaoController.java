package com.example.ispay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ispay.entity.Cartao;
import com.example.ispay.service.CartaoService;

@RestController
public class CartaoController {
	
	@Autowired
	private CartaoService cartaoService;
	
	@PostMapping("/addCartao")
	public Cartao addCartao(@RequestBody Cartao cartao) {
		return cartaoService.criarCartao(cartao);
	}
	
	@PostMapping("/addCartoes")
	public List<Cartao> addCartoes(@RequestBody List<Cartao> cartoes) {
		return cartaoService.criarCartoes(cartoes);
	}
	
	@GetMapping("/cartao/{id}")
	public Cartao pegarCartao(@PathVariable int id) {
		return cartaoService.pegarCartao(id);
	}
	
	@GetMapping("/cartoes")
	public List<Cartao> pegarTodosCartoes() {
		return cartaoService.pegarCartoes();
	}
	
	@PutMapping("/atualizarCartao")
	public Cartao atualizarCartao(@RequestBody Cartao cartao) {
		return cartaoService.atualizarCartao(cartao);
	}
	
	@DeleteMapping("/cartao/{id}")
	public String deletarCartao(@PathVariable int id) {
		return cartaoService.deletarCartao(id);
	}
	
}
