package com.minik.laberinto.model.entity;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="objetos")
@NamedQuery(name="Objeto.findAll", query="SELECT o FROM Objeto o")
public class Objeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte consumible;

	private String nombre;

	private double peso;

	private int valor;

	//bi-directional many-to-one association to Personaje
	@ManyToOne
	private Personaje personaje;

	public Objeto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getConsumible() {
		return this.consumible;
	}

	public void setConsumible(byte consumible) {
		this.consumible = consumible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}