package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="mision")
@NamedQuery(name="Mision.findAll", query="SELECT m FROM Mision m")
public class Mision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String estado;

	private String objetivos;

	private String recompensa;

	@Column(name="tiempo_restante")
	private int tiempoRestante;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	private Lugar lugar;

	public Mision() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getRecompensa() {
		return this.recompensa;
	}

	public void setRecompensa(String recompensa) {
		this.recompensa = recompensa;
	}

	public int getTiempoRestante() {
		return this.tiempoRestante;
	}

	public void setTiempoRestante(int tiempoRestante) {
		this.tiempoRestante = tiempoRestante;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}