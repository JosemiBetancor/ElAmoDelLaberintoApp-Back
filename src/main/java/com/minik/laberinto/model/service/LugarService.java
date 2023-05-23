package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Lugar;

@Repository
public interface LugarService {
	public List<Lugar> findAll();

	public Lugar findById(int id);

	public Lugar save(Lugar m);

	public void delete(int id);
}
