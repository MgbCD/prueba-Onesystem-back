package com.Onesystem.prueba.service;

import com.Onesystem.prueba.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    Alumno createAlumno(Alumno alumno);
    Optional<Alumno> getAlumnoById(Long id);
    List<Alumno> getAllAlumnos();
    Alumno updateAlumno(Long id, Alumno alumno);
    void deleteAlumno(Long id);
}