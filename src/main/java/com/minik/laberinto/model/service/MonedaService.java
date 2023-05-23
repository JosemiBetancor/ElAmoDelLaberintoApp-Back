package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Moneda;

@Repository
public interface MonedaService {
	public List<Moneda> findAll();

	public Moneda findById(int id);

	public Moneda save(Moneda m);

	public void delete(int id);
}
