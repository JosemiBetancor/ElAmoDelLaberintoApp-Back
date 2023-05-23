package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="personaje")
@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p")
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String alineamiento;

	private String clase;

	private int experiencia;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Habilidad
	@OneToMany(mappedBy="personaje")
	private List<Habilidad> habilidads;

	//bi-directional many-to-one association to Objeto
	@OneToMany(mappedBy="personaje")
	private List<Objeto> objetos;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	private Lugar lugar;

	//bi-directional one-to-one association to Moneda
	@OneToOne(mappedBy="personaje")
	private Moneda moneda;

	public Personaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlineamiento() {
		return this.alineamiento;
	}

	public void setAlineamiento(String alineamiento) {
		this.alineamiento = alineamiento;
	}

	public String getClase() {
		return this.clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Habilidad> getHabilidads() {
		return this.habilidads;
	}

	public void setHabilidads(List<Habilidad> habilidads) {
		this.habilidads = habilidads;
	}

	public Habilidad addHabilidad(Habilidad habilidad) {
		getHabilidads().add(habilidad);
		habilidad.setPersonaje(this);

		return habilidad;
	}

	public Habilidad removeHabilidad(Habilidad habilidad) {
		getHabilidads().remove(habilidad);
		habilidad.setPersonaje(null);

		return habilidad;
	}

	public List<Objeto> getObjetos() {
		return this.objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

	public Objeto addObjeto(Objeto objeto) {
		getObjetos().add(objeto);
		objeto.setPersonaje(this);

		return objeto;
	}

	public Objeto removeObjeto(Objeto objeto) {
		getObjetos().remove(objeto);
		objeto.setPersonaje(null);

		return objeto;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

}