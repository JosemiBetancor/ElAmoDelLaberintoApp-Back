package com.minik.laberinto.model.dto;

import com.minik.laberinto.model.entity.Moneda;

public class MonedaDTO {
	private final int id;
	private final int bronce;
	private final int plata;
	private final int oro;
	private final int platino;
	
	public MonedaDTO(int id, int bronce, int plata, int oro, int platino) {
		this.id = id;
		this.bronce = bronce;
		this.plata = plata;
		this.oro = oro;
		this.platino = platino;
	}
	
	public static MonedaDTO newInstance(Moneda m) {
		return new MonedaDTO(m.getId(),m.getBronce(), m.getPlata(), m.getOro(),m.getPlatino());

	}

	public int getId() {
		return id;
	}

	public int getBronce() {
		return bronce;
	}

	public int getPlata() {
		return plata;
	}

	public int getOro() {
		return oro;
	}

	public int getPlatino() {
		return platino;
	}
	
	
}
