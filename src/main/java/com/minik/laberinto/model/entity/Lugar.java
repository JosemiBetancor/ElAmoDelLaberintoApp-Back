package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="lugar")
@NamedQuery(name="Lugar.findAll", query="SELECT l FROM Lugar l")
public class Lugar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="alineacion_asignada")
	private String alineacionAsignada;

	@Column(name="clase_asignada")
	private String claseAsignada;

	private String tipo;

	//bi-directional many-to-one association to Mision
	@OneToMany(mappedBy="lugar")
	private List<Mision> misions;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="lugar")
	private List<Personaje> personajes;

	public Lugar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlineacionAsignada() {
		return this.alineacionAsignada;
	}

	public void setAlineacionAsignada(String alineacionAsignada) {
		this.alineacionAsignada = alineacionAsignada;
	}

	public String getClaseAsignada() {
		return this.claseAsignada;
	}

	public void setClaseAsignada(String claseAsignada) {
		this.claseAsignada = claseAsignada;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Mision> getMisions() {
		return this.misions;
	}

	public void setMisions(List<Mision> misions) {
		this.misions = misions;
	}

	public Mision addMision(Mision mision) {
		getMisions().add(mision);
		mision.setLugar(this);

		return mision;
	}

	public Mision removeMision(Mision mision) {
		getMisions().remove(mision);
		mision.setLugar(null);

		return mision;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje addPersonaje(Personaje personaje) {
		getPersonajes().add(personaje);
		personaje.setLugar(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setLugar(null);

		return personaje;
	}

}