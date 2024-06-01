package com.Onesystem.prueba.controller;

import com.Onesystem.prueba.model.Alumno;
import com.Onesystem.prueba.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080"})

public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping

    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.getAlumnoById(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping

    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.createAlumno(alumno);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        try {
            Alumno updatedAlumno = alumnoService.updateAlumno(id, alumnoDetails);
            return ResponseEntity.ok(updatedAlumno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        if (alumnoService.getAlumnoById(id).isPresent()) {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}