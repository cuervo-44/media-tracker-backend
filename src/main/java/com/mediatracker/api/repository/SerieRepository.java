package com.mediatracker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediatracker.api.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {

}
