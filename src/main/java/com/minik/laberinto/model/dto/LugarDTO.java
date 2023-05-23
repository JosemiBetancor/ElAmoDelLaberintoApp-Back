package com.minik.laberinto.model.dto;

import com.minik.laberinto.model.entity.Lugar;

public class LugarDTO {
	
	private int id;
	
	private String alineacionAsignada;

	private String claseAsignada;

	private String tipo;

	public LugarDTO(int id, String alineacionAsignada, String claseAsignada, String tipo) {
		super();
		this.id = id;
		this.alineacionAsignada = alineacionAsignada;
		this.claseAsignada = claseAsignada;
		this.tipo = tipo;
	}
	public static LugarDTO newInstance(Lugar p) {
		return new LugarDTO(p.getId(), p.getAlineacionAsignada() ,p.getClaseAsignada(),p.getTipo());

	}
	public int getId() {
		return id;
	}

	public String getAlineacionAsignada() {
		return alineacionAsignada;
	}

	public String getClaseAsignada() {
		return claseAsignada;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}
