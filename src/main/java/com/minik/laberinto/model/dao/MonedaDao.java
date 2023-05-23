package com.minik.laberinto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minik.laberinto.model.entity.Moneda;

public interface MonedaDao extends JpaRepository<Moneda, Integer> {

}
