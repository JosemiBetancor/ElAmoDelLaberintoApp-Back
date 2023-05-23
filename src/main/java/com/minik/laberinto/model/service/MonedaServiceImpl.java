package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.MonedaDao;
import com.minik.laberinto.model.entity.Moneda;

@Service
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	private MonedaDao rep;

	@Override
	public List<Moneda> findAll() {
		return (List<Moneda>) rep.findAll();
	}

	@Override
	public Moneda findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Moneda save(Moneda m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}
}
