package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Objeto;

@Repository
public interface ObjetoService {
	public List<Objeto> findAll();

	public Objeto findById(int id);

	public Objeto save(Objeto m);

	public void delete(int id);
}
