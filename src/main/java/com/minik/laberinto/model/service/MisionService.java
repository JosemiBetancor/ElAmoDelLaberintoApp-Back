package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minik.laberinto.model.entity.Mision;

@Repository
public interface MisionService {
	public List<Mision> findAll();

	public Mision findById(int id);

	public Mision save(Mision m);

	public void delete(int id);
}
