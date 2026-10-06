package com.mediatracker.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "temporada")
public class Temporada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int numeroTemporada;
	private int numeroCapitulos;
	private int anyo;
	private double puntuacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serie_id")
	private Serie serie;
	
	public Temporada() {
		
	}

	public Temporada(int numeroTemporada, int numeroCapitulos, int anyo, double puntuacion, Serie serie) {
		this.numeroTemporada = numeroTemporada;
		this.numeroCapitulos = numeroCapitulos;
		this.anyo = anyo;
		this.puntuacion = puntuacion;
		this.serie = serie;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	public int getNumeroCapitulos() {
		return numeroCapitulos;
	}

	public void setNumeroCapitulos(int numeroCapitulos) {
		this.numeroCapitulos = numeroCapitulos;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "Temporada [id=" + id + ", numeroTemporada=" + numeroTemporada + ", numeroCapitulos=" + numeroCapitulos
				+ ", anyo=" + anyo + ", puntuacion=" + puntuacion + ", serie=" + serie + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
