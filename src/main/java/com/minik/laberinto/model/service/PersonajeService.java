package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Personaje;

@Repository
public interface PersonajeService {
	public List<Personaje> findAll();

	public Personaje findById(int id);

	public Personaje save(Personaje m);

	public void delete(int id);
}
