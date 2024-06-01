package com.Onesystem.prueba.controller;

import com.Onesystem.prueba.model.Profesor;
import com.Onesystem.prueba.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesor")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080"})
public class ProfesorController {

    @Autowired
    private ProfesorService ProfesorService;

    @GetMapping
    public List<Profesor> getAllProfesors() {
        return ProfesorService.getAllProfesors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        Optional<Profesor> Profesor = ProfesorService.getProfesorById(id);
        return Profesor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @GetMapping
    public Profesor createProfesor(@RequestBody Profesor Profesor) {
        return ProfesorService.createProfesor(Profesor);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor ProfesorDetails) {
        try {
            Profesor updatedProfesor = ProfesorService.updateProfesor(id, ProfesorDetails);
            return ResponseEntity.ok(updatedProfesor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        if (ProfesorService.getProfesorById(id).isPresent()) {
            ProfesorService.deleteProfesor(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}