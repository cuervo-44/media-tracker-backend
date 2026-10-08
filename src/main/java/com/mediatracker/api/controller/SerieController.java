package com.mediatracker.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediatracker.api.model.Serie;
import com.mediatracker.api.service.SerieService;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "http://localhost:4200")
public class SerieController {
	private final SerieService serieService;

	public SerieController(SerieService serieService) {
		this.serieService = serieService;
	}
	
    @GetMapping
    public ResponseEntity<List<Serie>> listarTodas(@RequestParam(required = false) String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            return ResponseEntity.ok(serieService.buscarPorNombre(titulo));
        }
        return ResponseEntity.ok(serieService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> obtenerPorId(@PathVariable Long id) {
        return serieService.obtenerporId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Serie> crearOActualizar(@RequestBody Serie serie) {
        Serie guardada = serieService.guardar(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        serieService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
	
	

}
