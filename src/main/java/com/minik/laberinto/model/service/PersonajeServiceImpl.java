package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.PersonajeDao;
import com.minik.laberinto.model.entity.Personaje;

@Service
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeDao rep;

	@Override
	public List<Personaje> findAll() {
		return (List<Personaje>) rep.findAll();
	}

	@Override
	public Personaje findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Personaje save(Personaje m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}

}
