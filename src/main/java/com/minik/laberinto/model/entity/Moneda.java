package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "moneda")
@NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int bronce;

	private int oro;

	private int plata;

	private int platino;

	// bi-directional one-to-one association to Personaje
	@OneToOne
	private Personaje personaje;

	public Moneda() {
	}

	public int getBronce() {
		return this.bronce;
	}

	public void setBronce(int bronce) {
		this.bronce = bronce;
	}

	public int getOro() {
		return this.oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getPlata() {
		return this.plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public int getPlatino() {
		return this.platino;
	}

	public void setPlatino(int platino) {
		this.platino = platino;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}