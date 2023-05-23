package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="habilidad")
@NamedQuery(name="Habilidad.findAll", query="SELECT h FROM Habilidad h")
public class Habilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte interpretativas;

	private String nombre;

	//bi-directional many-to-one association to Personaje
	@ManyToOne
	private Personaje personaje;

	public Habilidad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getInterpretativas() {
		return this.interpretativas;
	}

	public void setInterpretativas(byte interpretativas) {
		this.interpretativas = interpretativas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}