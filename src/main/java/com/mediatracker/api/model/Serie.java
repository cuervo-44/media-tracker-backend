package com.mediatracker.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "serie")
public class Serie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Temporada> temporadas;
	
	private int anyo;

	public Serie() {
		
	}

	public Serie(String nombre, List<Temporada> temporadas, int anyo) {
		this.nombre = nombre;
		this.temporadas = temporadas;
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

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + ", temporadas=" + temporadas + ", anyo=" + anyo + "]";
	}
	
	
	
	
	
	
}
