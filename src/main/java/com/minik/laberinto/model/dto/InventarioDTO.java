package com.minik.laberinto.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.minik.laberinto.model.entity.Objeto;

public class InventarioDTO {
	private final int id;
	private final int idPersonaje;
	private final byte consumible;
	private final String nombre;
	private final double peso;
	private final int valor;

	public InventarioDTO(int id, byte consumible, String nombre, double peso, int valor, int idPersonaje) {
		super();
		this.id = id;
		this.consumible = consumible;
		this.nombre = nombre;
		this.peso = peso;
		this.valor = valor;
		this.idPersonaje = idPersonaje;
	}

	public static InventarioDTO newInstance(Objeto p) {
		return new InventarioDTO(p.getId(), p.getConsumible(), p.getNombre(), p.getPeso(), p.getValor(),
				p.getPersonaje().getId());
	}

	public static List<InventarioDTO> mapList(List<Objeto> objetos) {
		if (objetos == null) {
			return null;
		}
		List<InventarioDTO> dtos = new ArrayList<>();
		for (Objeto object : objetos) {
			dtos.add(newInstance(object));
		}
		return dtos;
	}

	public int getId() {
		return id;
	}

	public byte getConsumible() {
		return consumible;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPeso() {
		return peso;
	}

	public int getValor() {
		return valor;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}
}
