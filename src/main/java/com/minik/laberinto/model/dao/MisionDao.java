package com.minik.laberinto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minik.laberinto.model.entity.Mision;

public interface MisionDao extends JpaRepository<Mision, Integer> {

}
