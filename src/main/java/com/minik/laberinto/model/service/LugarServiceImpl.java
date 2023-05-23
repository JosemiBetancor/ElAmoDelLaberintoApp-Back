package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.LugarDao;
import com.minik.laberinto.model.entity.Lugar;

@Service
public class LugarServiceImpl implements LugarService {

	@Autowired
	private LugarDao rep;

	@Override
	public List<Lugar> findAll() {
		return (List<Lugar>) rep.findAll();
	}

	@Override
	public Lugar findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Lugar save(Lugar m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}

}
