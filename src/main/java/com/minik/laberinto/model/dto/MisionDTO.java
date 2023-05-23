package com.minik.laberinto.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.minik.laberinto.model.entity.Mision;

public class MisionDTO {
	private int id;

	private String estado;

	private String objetivos;

	private String recompensa;

	private int tiempoRestante;
	private int idLugar;

	public MisionDTO(int id, String estado, String objetivos, String recompensa, int tiempoRestante,int idLugar) {
		this.id = id;
		this.estado = estado;
		this.objetivos = objetivos;
		this.recompensa = recompensa;
		this.tiempoRestante = tiempoRestante;
		this.idLugar = idLugar;
	}

	public static MisionDTO newInstance(Mision m) {
		return new MisionDTO(m.getId(), m.getEstado(), m.getObjetivos(), m.getRecompensa(), m.getTiempoRestante(),m.getLugar().getId());

	}
	public static List<MisionDTO> mapList(List<Mision> misiones) {
	    if (misiones == null) {
	        return null;
	    }
	    List<MisionDTO> dtos = new ArrayList<>();
	    for (Mision mision : misiones) {
	        dtos.add(newInstance(mision));
	    }
	    return dtos;
	}
	public int getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public String getRecompensa() {
		return recompensa;
	}

	public int getTiempoRestante() {
		return tiempoRestante;
	}

	public int getIdLugar() {
		return idLugar;
	}

}
