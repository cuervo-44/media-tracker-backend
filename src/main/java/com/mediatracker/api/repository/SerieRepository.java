package com.mediatracker.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediatracker.api.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	List<Serie> findByNombreContainingIgnoreCase(String nombre);
}
