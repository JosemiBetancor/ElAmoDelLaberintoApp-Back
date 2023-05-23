package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.HabilidadDao;
import com.minik.laberinto.model.entity.Habilidad;

@Service
public class HabilidadServiceImpl implements HabilidadService {

	@Autowired
	private HabilidadDao rep;

	@Override
	public List<Habilidad> findAll() {
		return (List<Habilidad>) rep.findAll();
	}

	@Override
	public Habilidad findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Habilidad save(Habilidad m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}

}
