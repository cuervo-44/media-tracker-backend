package com.mediatracker.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mediatracker.api.model.Serie;
import com.mediatracker.api.repository.SerieRepository;
import com.mediatracker.api.service.SerieService;

@Service
public class SerieServiceImpl implements SerieService {
	
	private final SerieRepository serieRepository;
	
	public SerieServiceImpl(SerieRepository serieRepository) {
		this.serieRepository = serieRepository;
	}

	@Override
	public List<Serie> obtenerTodas() {
		
		return serieRepository.findAll();
	}

	@Override
	public Optional<Serie> obtenerporId(Long id) {
		return serieRepository.findById(id);
	}

	@Override
	public Serie guardar(Serie serie) {
		
		if (serie.getTemporadas() != null) {
			serie.getTemporadas().forEach(temporada -> temporada.setSerie(serie));
		}
		return serieRepository.save(serie);
	}

	@Override
	public void eliminar(Long id) {
		serieRepository.deleteById(id);
		
	}

	@Override
	public List<Serie> buscarPorNombre(String titulo) {
		return serieRepository.findByNombreContainingIgnoreCase(titulo);
	}

}
