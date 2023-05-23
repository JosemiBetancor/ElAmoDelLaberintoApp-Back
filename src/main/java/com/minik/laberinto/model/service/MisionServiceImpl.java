package com.minik.laberinto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minik.laberinto.model.dao.MisionDao;
import com.minik.laberinto.model.entity.Mision;

@Service
public class MisionServiceImpl implements MisionService {

	@Autowired
	private MisionDao rep;

	@Override
	public List<Mision> findAll() {
		return (List<Mision>) rep.findAll();
	}

	@Override
	public Mision findById(int id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Mision save(Mision m) {
		return rep.save(m);
	}

	@Override
	public void delete(int id) {
		rep.delete(rep.findById(id).orElse(null));

	}

}
