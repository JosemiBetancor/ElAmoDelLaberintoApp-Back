package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.ObjetoDao;
import com.minik.laberinto.model.entity.Objeto;

@Service
public class ObjetoServiceImpl implements ObjetoService {

	@Autowired
	private ObjetoDao rep;

	@Override
	public List<Objeto> findAll() {
		return (List<Objeto>) rep.findAll();
	}

	@Override
	public Objeto findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Objeto save(Objeto m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}

}
