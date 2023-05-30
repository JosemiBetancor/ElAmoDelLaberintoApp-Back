package com.minik.laberinto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minik.laberinto.model.dto.MonedaDTO;
import com.minik.laberinto.model.entity.Moneda;
import com.minik.laberinto.model.entity.Personaje;
import com.minik.laberinto.model.service.MonedaService;
import com.minik.laberinto.model.service.PersonajeService;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class MonedaController {

	@Autowired
	MonedaService monedaService;
	@Autowired
	PersonajeService personajeService;
	
	
	@GetMapping("/monedas")
	public List<MonedaDTO> getMonedero() {
		return monedaService.findAll()
				.stream()
				.map(MonedaDTO::newInstance)
				.collect(Collectors.toList());
	}
	@GetMapping("/monedero/{idPersonaje}")
	public ResponseEntity<MonedaDTO> getMonedero(@PathVariable int idPersonaje) {
		Personaje personaje= personajeService.findById(idPersonaje);
		Moneda moneda=personaje.getMoneda();
		return new ResponseEntity<>(MonedaDTO.newInstance(moneda), HttpStatus.OK);
	}
	@PutMapping("/moneda/monedero/{id}")
	public ResponseEntity<?> UpdateBronce(@RequestBody Moneda monedero, @PathVariable int id) {
	    Moneda current = monedaService.findById(id);
	    current.setBronce(monedero.getBronce());
	    current.setPlata(monedero.getPlata());
	    current.setOro(monedero.getOro());
	    current.setPlatino(monedero.getPlatino());
	    monedaService.save(current);
	    return new ResponseEntity<>(MonedaDTO.newInstance(current), HttpStatus.OK);
	}
	

	@PostMapping("/monedero/{idPersonaje}")
	public ResponseEntity<?> addPersonaje(@PathVariable int idPersonaje,@RequestBody Moneda moneda) {
		Personaje p = personajeService.findById(idPersonaje);
		Moneda current= new Moneda();
		current.setBronce(moneda.getBronce());
		current.setPlata(moneda.getPlata());
		current.setOro(moneda.getOro());
		current.setPlatino(moneda.getPlatino());
		current.setPersonaje(p);
		monedaService.save(current);
		return new ResponseEntity<>(MonedaDTO.newInstance(current), HttpStatus.OK);
	}

}
