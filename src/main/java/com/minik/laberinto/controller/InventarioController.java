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

import com.minik.laberinto.model.dto.InventarioDTO;
import com.minik.laberinto.model.entity.Objeto;
import com.minik.laberinto.model.entity.Personaje;
import com.minik.laberinto.model.service.ObjetoService;
import com.minik.laberinto.model.service.PersonajeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class InventarioController {
	
	@Autowired
	ObjetoService InventarioService;
	@Autowired
	PersonajeService PersonajeService;
	
	@GetMapping("/personajes/{id}/objetos")
	public ResponseEntity<?> getInventarioByPersonajeId(@PathVariable int id) {
	    Personaje personaje = PersonajeService.findById(id);
	    if (personaje == null) {
	        return ResponseEntity.notFound().build();
	    }

	    List<Objeto> objetos = personaje.getObjetos();
	    List<InventarioDTO> inventario = InventarioDTO.mapList(objetos);

	    return ResponseEntity.ok().body(inventario);
	}
	
	@PostMapping("/objeto/{id}")
	public ResponseEntity<?> addObjeto(@RequestBody Objeto o,@PathVariable int id) {
		Personaje personaje = PersonajeService.findById(id);
		Objeto object= new Objeto();
		object.setConsumible(o.getConsumible());
		object.setNombre(o.getNombre());
		object.setPeso(o.getPeso());
		object.setValor(o.getValor());
		object.setPersonaje(personaje);
		InventarioService.save(object);
		return new ResponseEntity<>(InventarioDTO.newInstance(object), HttpStatus.OK);
	}
	@PutMapping("/objeto/{id}")
	public ResponseEntity<?> updateObjeto(@RequestBody Objeto o,@PathVariable int id) {
		Objeto object=InventarioService.findById(id);
		object.setConsumible(o.getConsumible());
		object.setNombre(o.getNombre());
		object.setPeso(o.getPeso());
		object.setValor(o.getValor());
		InventarioService.save(object);
		return new ResponseEntity<>(InventarioDTO.newInstance(object), HttpStatus.OK);
	}
	
	@DeleteMapping("/objeto/{id}")
	public ResponseEntity<?> deleteObjeto(@PathVariable int id) {
		InventarioService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
