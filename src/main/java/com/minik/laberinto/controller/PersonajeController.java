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

import com.minik.laberinto.model.dto.PersonajeDTO;
import com.minik.laberinto.model.entity.Personaje;
import com.minik.laberinto.model.service.LugarService;
import com.minik.laberinto.model.service.PersonajeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonajeController {

	@Autowired
	PersonajeService PersonajeService;
	
	@Autowired
	LugarService lugarService;
	
	@GetMapping("/personajes")
	public List<PersonajeDTO> getUsers() {
		return PersonajeService.findAll()
				.stream()
				.map(PersonajeDTO::newInstance)
				.collect(Collectors.toList());
	}

	@GetMapping("/personaje/{id}")
	public PersonajeDTO getPersonaje(@PathVariable int id) {
		Personaje p = PersonajeService.findById(id);
		return PersonajeDTO.newInstance(p);
	}

	@PostMapping("/personaje")
	public ResponseEntity<?> addPersonaje(@RequestBody Personaje m) {
		Personaje p = new Personaje();
		p.setAlineamiento(m.getAlineamiento());
		p.setClase(m.getClase());
		p.setExperiencia(m.getExperiencia());
		p.setHabilidads(m.getHabilidads());
		p.setObjetos(m.getObjetos());
		p.setLugar(m.getLugar());
		p.setNivel(m.getNivel());
		p.setNombre(m.getNombre());
		PersonajeService.save(p);
		return new ResponseEntity<>(PersonajeDTO.newInstance(p), HttpStatus.OK);
	}

	@PutMapping("/personaje/{id}")
	public ResponseEntity<?> addPersonaje(@RequestBody Personaje m, @PathVariable int id) {
		Personaje current = PersonajeService.findById(id);
		current.setAlineamiento(m.getAlineamiento());
		current.setClase(m.getClase());
		current.setExperiencia(m.getExperiencia());
		current.setNivel(m.getNivel());
		current.setNombre(m.getNombre());
		PersonajeService.save(current);
		return new ResponseEntity<>(PersonajeDTO.newInstance(current), HttpStatus.OK);
	}

	@DeleteMapping("/personaje/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable int id) {
		PersonajeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}