package com.minik.laberinto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minik.laberinto.model.entity.Lugar;

public interface LugarDao extends JpaRepository<Lugar, Integer> {

}
