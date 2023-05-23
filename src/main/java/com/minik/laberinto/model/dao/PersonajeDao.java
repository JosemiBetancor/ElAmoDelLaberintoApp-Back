package com.minik.laberinto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minik.laberinto.model.entity.Personaje;

public interface PersonajeDao extends JpaRepository<Personaje, Integer> {

}
