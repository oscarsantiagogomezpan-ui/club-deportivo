package com.servicios.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;

@RestController
@RequestMapping("/api/v1/clubes")
public class ClubesController {

    // Simulación de base de datos en memoria
    private List<Map<String, Object>> clubes = new ArrayList<>(Arrays.asList(
        Map.of("id", 1, "nombre", "Club Leones", "deporte", "Fútbol"),
        Map.of("id", 2, "nombre", "Águilas Doradas", "deporte", "Baloncesto")
    ));

    // GET: Obtener todos o uno por ID
    @GetMapping
    public ResponseEntity<?> obtenerClubes(@RequestParam(required = false) Integer id) {
        if (id == null) {
            return ResponseEntity.ok(clubes);
        }
        return ResponseEntity.ok(Map.of("id", id, "nombre", "Club Consultado", "status", "Activo"));
    }

    // POST: Crear un club (Con la validación que pide tu guía)
    @PostMapping
    public ResponseEntity<?> crearClub(@RequestParam String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "El nombre del club es obligatorio para el registro"));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(Map.of("mensaje", "Club '" + nombre + "' creado exitosamente", "id", 101));
    }

    // PUT: Actualizar
    @PutMapping
    public ResponseEntity<?> actualizarClub(@RequestParam Integer id) {
        return ResponseEntity.ok(Map.of("mensaje", "Club con ID " + id + " actualizado correctamente"));
    }

    // DELETE: Eliminar
    @DeleteMapping
    public ResponseEntity<?> eliminarClub(@RequestParam Integer id) {
        return ResponseEntity.ok(Map.of("mensaje", "Club " + id + " eliminado del sistema"));
    }
}