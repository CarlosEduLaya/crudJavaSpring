package com.example.ispay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ispay.entity.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
