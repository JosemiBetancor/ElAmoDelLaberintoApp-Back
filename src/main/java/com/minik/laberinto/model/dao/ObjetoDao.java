package com.minik.laberinto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minik.laberinto.model.entity.Objeto;

public interface ObjetoDao extends JpaRepository<Objeto, Integer> {

}
