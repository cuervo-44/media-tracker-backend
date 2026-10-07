package com.mediatracker.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mediatracker.api.model.Pelicula;
import com.mediatracker.api.repository.PeliculaRepository;
import com.mediatracker.api.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	private final PeliculaRepository peliculaRepository;
	
	public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	@Override
	public List<Pelicula> obtenerTodas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Optional obtenerporId(Long id) {
		return peliculaRepository.findById(id);
	}

	@Override
	public Pelicula guardar(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void eliminar(Long id) {
		peliculaRepository.deleteById(id);
	}

	@Override
	public List <Pelicula> buscarPorNombre(String titulo) {
		return peliculaRepository.findByNombreContainingIgnoreCase(titulo);
	}

}
