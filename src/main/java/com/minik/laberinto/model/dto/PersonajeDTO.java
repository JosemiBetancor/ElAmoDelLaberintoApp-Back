package com.minik.laberinto.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.minik.laberinto.model.entity.Personaje;

public class PersonajeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int id;
	private final String alineamiento;
	private final String clase;
	private final int experiencia;
	private final int nivel;
	private final String nombre;

	public PersonajeDTO(int id, String alineamiento, String clase, int experiencia, int nivel, String nombre) {
		super();
		this.id = id;
		this.alineamiento = alineamiento;
		this.clase = clase;
		this.experiencia = experiencia;
		this.nivel = nivel;
		this.nombre = nombre;
	}

	public static PersonajeDTO newInstance(Personaje p) {
		return new PersonajeDTO(p.getId(), p.getAlineamiento(), p.getClase(), p.getExperiencia(), p.getNivel(),
				p.getNombre());

	}
	public static List<PersonajeDTO> mapList(List<Personaje> personajes) {
	    if (personajes == null) {
	        return null;
	    }
	    List<PersonajeDTO> dtos = new ArrayList<>();
	    for (Personaje personaje : personajes) {
	        dtos.add(newInstance(personaje));
	    }
	    return dtos;
	}
	
	public int getId() {
		return id;
	}

	public String getAlineamiento() {
		return alineamiento;
	}

	public String getClase() {
		return clase;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public String getNombre() {
		return nombre;
	}
}