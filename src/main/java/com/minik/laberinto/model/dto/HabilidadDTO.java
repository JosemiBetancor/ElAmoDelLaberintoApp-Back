package com.minik.laberinto.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.minik.laberinto.model.entity.Habilidad;

public class HabilidadDTO {
	private int id;

	private byte interpretativas;

	private String nombre;
	private int idPersonaje;

	public HabilidadDTO(int id, byte interpretativas, String nombre,int idPersonaje) {
		super();
		this.id = id;
		this.interpretativas = interpretativas;
		this.nombre = nombre;
		this.idPersonaje=idPersonaje;
	}

	public static HabilidadDTO newInstance(Habilidad p) {
		return new HabilidadDTO(p.getId(), p.getInterpretativas() ,p.getNombre(),p.getPersonaje().getId());

	}
	public static List<HabilidadDTO> mapList(List<Habilidad> habilidades) {
		if (habilidades == null) {
			return null;
		}
		List<HabilidadDTO> dtos = new ArrayList<>();
		for (Habilidad hab : habilidades) {
			dtos.add(newInstance(hab));
		}
		return dtos;
	}
	
	public int getId() {
		return id;
	}

	public byte getInterpretativas() {
		return interpretativas;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}
	
}
