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
	private final int claseArmadura;
	private final int vida;
	private final String nombre;
	private final String imagen;

	public PersonajeDTO(int id, String alineamiento, String clase, int experiencia, int nivel,int claseArmadura,int vida, String nombre,String imagen) {
		super();
		this.id = id;
		this.alineamiento = alineamiento;
		this.clase = clase;
		this.experiencia = experiencia;
		this.nivel = nivel;
		this.nombre = nombre;
		this.imagen=imagen;
		this.claseArmadura=claseArmadura;
		this.vida=vida;
	}

	public static PersonajeDTO newInstance(Personaje p) {
		return new PersonajeDTO(p.getId(), p.getAlineamiento(), p.getClase(), p.getExperiencia(), p.getNivel(),p.getClaseArmadura(),p.getVida(),
				p.getNombre(),p.getImagen());

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getImagen() {
		return imagen;
	}

	public int getClaseArmadura() {
		return claseArmadura;
	}

	public int getVida() {
		return vida;
	}
	
}