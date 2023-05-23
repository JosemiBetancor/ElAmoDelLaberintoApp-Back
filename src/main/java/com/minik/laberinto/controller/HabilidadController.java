package com.minik.laberinto.controller;

import java.util.List;

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

import com.minik.laberinto.model.dto.HabilidadDTO;
import com.minik.laberinto.model.entity.Habilidad;
import com.minik.laberinto.model.entity.Personaje;
import com.minik.laberinto.model.service.HabilidadService;
import com.minik.laberinto.model.service.PersonajeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class HabilidadController {

	@Autowired
	HabilidadService HabilidadService;
	@Autowired
	PersonajeService PersonajeService;

	@GetMapping("/habilidades/personaje/{idPersonaje}")
	public ResponseEntity<?> getHabilidadesByPersonajeId(@PathVariable int idPersonaje) {
		Personaje personaje = PersonajeService.findById(idPersonaje);
		List<Habilidad> habilidades = personaje.getHabilidads();
		List<HabilidadDTO> habsPersonaje = HabilidadDTO.mapList(habilidades);
		return ResponseEntity.ok(habsPersonaje);
	}

	@PostMapping("/habilidad/{idPersonaje}")
	public ResponseEntity<?> addHabilidad(@RequestBody Habilidad h, @PathVariable int idPersonaje) {
		Habilidad habilidad = new Habilidad();
		Personaje personaje = PersonajeService.findById(idPersonaje);
		habilidad.setInterpretativas(h.getInterpretativas());
		habilidad.setNombre(h.getNombre());
		habilidad.setPersonaje(personaje);
		HabilidadService.save(habilidad);
		return new ResponseEntity<>(HabilidadDTO.newInstance(habilidad), HttpStatus.OK);
	}

	@PutMapping("/habilidad/personaje/{id}")
	public ResponseEntity<?> addHabilidadToPersonaje(@RequestBody Habilidad h, @PathVariable int id) {
		Habilidad hab = HabilidadService.findById(id);
		hab.setInterpretativas(h.getInterpretativas());
		hab.setNombre(h.getNombre());
		HabilidadService.save(hab);
		return new ResponseEntity<>(HabilidadDTO.newInstance(hab), HttpStatus.OK);
	}
	
	@DeleteMapping("/habilidad/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable int id) {
		HabilidadService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
