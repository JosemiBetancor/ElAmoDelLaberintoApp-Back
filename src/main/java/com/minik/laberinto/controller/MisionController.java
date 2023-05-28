package com.minik.laberinto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minik.laberinto.model.dto.MisionDTO;
import com.minik.laberinto.model.entity.Lugar;
import com.minik.laberinto.model.entity.Mision;
import com.minik.laberinto.model.service.LugarService;
import com.minik.laberinto.model.service.MisionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class MisionController {

	@Autowired
	MisionService MisionService;
	@Autowired
	LugarService lugarService;

	@GetMapping("/misiones")
	public List<MisionDTO> getMissions() {
		return MisionService.findAll().stream().map(MisionDTO::newInstance).collect(Collectors.toList());
	}

	@GetMapping("/mision/{id}")
	public MisionDTO getMission(@PathVariable int id) {
		Mision m = MisionService.findById(id);
		return MisionDTO.newInstance(m);
	}
	
	
	@PostMapping("/mision/{idLugar}")
	public ResponseEntity<?> addMision(@RequestBody Mision m, @PathVariable int idLugar) {
		Mision p = new Mision();
		Lugar l = lugarService.findById(idLugar);
		p.setEstado(m.getEstado());
		p.setLugar(l);
		p.setObjetivos(m.getObjetivos());
		p.setRecompensa(m.getRecompensa());
		p.setTiempoRestante(m.getTiempoRestante());
		MisionService.save(p);
		return new ResponseEntity<>(MisionDTO.newInstance(p), HttpStatus.OK);
	}
	
	@PutMapping("/mision/estado/{id}")
	public ResponseEntity<?> UpdateMision(@RequestBody String estado, @PathVariable int id) {
	    Mision current = MisionService.findById(id);
	    current.setEstado(estado);
	    MisionService.save(current);
	    return new ResponseEntity<>(MisionDTO.newInstance(current), HttpStatus.OK);
	}
	
	@PutMapping("/mision/timeout/{id}")
	public ResponseEntity<?> MisionTimeOut(@PathVariable int id) {
	    Mision current = MisionService.findById(id);
	    current.setTiempoRestante(0);
	    current.setEstado("FALLADO");
	    MisionService.save(current);
	    return new ResponseEntity<>(MisionDTO.newInstance(current), HttpStatus.OK);
	}
	
	@DeleteMapping("/mision/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable int id) {
		MisionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
