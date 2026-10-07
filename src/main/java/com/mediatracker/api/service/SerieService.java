package com.mediatracker.api.service;

import java.util.List;
import java.util.Optional;

import com.mediatracker.api.model.Serie;



public interface SerieService {
	List <Serie> obtenerTodas();
	Optional<Serie> obtenerporId(Long id);
	Serie guardar(Serie serie);
	void eliminar (Long id);
	List<Serie> buscarPorNombre(String titulo);
	
}
