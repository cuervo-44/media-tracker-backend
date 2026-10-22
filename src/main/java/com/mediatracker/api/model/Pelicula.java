package com.mediatracker.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table (name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private int duracion;
	
	@DecimalMin(value = "0.0", message = "La puntuación mínima es 1")
    @DecimalMax(value = "10.0", message = "La puntuación máxima es 10")
	private double puntuacion;
	private int anyo;
	
	public Pelicula() {}

	public Pelicula(String nombre, int duracion, double puntuacion, int anyo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.puntuacion = puntuacion;
		this.anyo = anyo;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", puntuacion=" + puntuacion
				+ ", anyo=" + anyo + "]";
	}



}
