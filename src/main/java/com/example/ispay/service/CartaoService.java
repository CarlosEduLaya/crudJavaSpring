package com.example.ispay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ispay.dao.CartaoRepository;
import com.example.ispay.entity.Cartao;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	public Cartao criarCartao(Cartao cartao) {
		return cartaoRepository.save(cartao);
	}
	
	public List<Cartao> criarCartoes(List<Cartao> cartoes) {
		return cartaoRepository.saveAll(cartoes);
	}
	
	public Cartao pegarCartao(int id) {
		return cartaoRepository.findById(id).orElse(null);
	}
	
	public List<Cartao> pegarCartoes() {
		return cartaoRepository.findAll();
	}
	
	public Cartao atualizarCartao(Cartao cartao) {
		Cartao velhoCartao = null;
		Optional<Cartao> optionalCartao= cartaoRepository.findById(cartao.getId());
		if(optionalCartao.isPresent()) {
			velhoCartao = optionalCartao.get();
			velhoCartao.setNumero(cartao.getNumero());
			velhoCartao.setNomeUsuario(cartao.getNomeUsuario());
			velhoCartao.setCodigoSeguranca(cartao.getCodigoSeguranca());
			velhoCartao.setDataValidade(cartao.getDataValidade());
			
			cartaoRepository.save(velhoCartao);

		}else{
			return new Cartao();	
		}
		return velhoCartao;
	}
	
	
	public String deletarCartao(int id) {
		 cartaoRepository.deleteById(id);
		 return "Cartao deletado";
	}
	
}
