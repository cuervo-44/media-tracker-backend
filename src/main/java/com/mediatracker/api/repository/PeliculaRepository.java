package com.mediatracker.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediatracker.api.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
	List<Pelicula> findByNombreContainingIgnoreCase(String nombre);
}
