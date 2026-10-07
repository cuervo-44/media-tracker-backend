package com.mediatracker.api.service;

import java.util.List;
import java.util.Optional;

import com.mediatracker.api.model.Pelicula;

public interface PeliculaService {
	List <Pelicula> obtenerTodas();
	Optional<Pelicula> obtenerporId(Long id);
	Pelicula guardar(Pelicula pelicula);
	void eliminar (Long id);
	List<Pelicula> buscarPorNombre(String titulo);
	
}

