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

import com.minik.laberinto.model.dto.LugarDTO;
import com.minik.laberinto.model.dto.MisionDTO;
import com.minik.laberinto.model.dto.PersonajeDTO;
import com.minik.laberinto.model.entity.Lugar;
import com.minik.laberinto.model.service.LugarService;
import com.minik.laberinto.model.service.PersonajeService;
@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LugarController {
	
	@Autowired
	LugarService LugarService;
	
	@Autowired
	PersonajeService personajeService;
	
	
	@GetMapping("/lugares")
public List<LugarDTO> getLugares(){
		return LugarService.findAll().stream().map(LugarDTO::newInstance).collect(Collectors.toList());
	}
	
	@GetMapping("/lugar/personajes/{idLugar}")
	public ResponseEntity<?> getPersonajesByLugar(@PathVariable int idLugar){
		Lugar l = LugarService.findById(idLugar);
		List<PersonajeDTO> personajes = PersonajeDTO.mapList(l.getPersonajes());
		return ResponseEntity.ok(personajes);
	}
	@GetMapping("/lugar/misiones/{idLugar}")
	public ResponseEntity<?> GetMisionesByLugar(@PathVariable int idLugar){
		Lugar l=LugarService.findById(idLugar);
		List<MisionDTO> misiones =MisionDTO.mapList(l.getMisions());
		return ResponseEntity.ok(misiones);
	}
	@PostMapping("/lugar")
	public ResponseEntity<?> addLugar(@RequestBody Lugar m) {
		Lugar p = new Lugar();
		p.setAlineacionAsignada(m.getAlineacionAsignada());
		p.setClaseAsignada(m.getClaseAsignada());
		p.setTipo(m.getTipo());
		LugarService.save(p);
		return new ResponseEntity<>(LugarDTO.newInstance(p), HttpStatus.OK);
	}
	@PutMapping("/lugar/{idLugar}")
	public ResponseEntity<?> updateLugar(@PathVariable int idLugar, @RequestBody Lugar l){
		Lugar lugar = LugarService.findById(idLugar);
		lugar.setAlineacionAsignada(l.getAlineacionAsignada());
		lugar.setClaseAsignada(l.getClaseAsignada());
		lugar.setTipo(l.getTipo());
		LugarService.save(lugar);
		return new ResponseEntity<>(LugarDTO.newInstance(lugar),HttpStatus.OK);
	}
	
	@DeleteMapping("/lugar/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable int id) {
		LugarService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
