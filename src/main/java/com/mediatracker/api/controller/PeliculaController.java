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

import com.mediatracker.api.model.Pelicula;
import com.mediatracker.api.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:4200")
public class PeliculaController {
	
	private final PeliculaService peliculaService;

	public PeliculaController(PeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}
	
	@GetMapping
    public ResponseEntity<List<Pelicula>> listarTodas(@RequestParam(required = false) String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            return ResponseEntity.ok(peliculaService.buscarPorNombre(titulo));
        }
        return ResponseEntity.ok(peliculaService.obtenerTodas());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPorId(@PathVariable Long id) {
        return peliculaService.obtenerporId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public ResponseEntity<Pelicula> crearOActualizar(@RequestBody Pelicula pelicula) {
        Pelicula guardada = peliculaService.guardar(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
	
}
