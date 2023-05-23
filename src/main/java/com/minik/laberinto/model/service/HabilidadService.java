package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Habilidad;

@Repository
public interface HabilidadService {
	public List<Habilidad> findAll();

	public Habilidad findById(int id);

	public Habilidad save(Habilidad m);

	public void delete(int id);
}
