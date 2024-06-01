package com.Onesystem.prueba.service;

import com.Onesystem.prueba.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    Profesor createProfesor(Profesor profesor);
    Optional<Profesor> getProfesorById(Long id);
    List<Profesor> getAllProfesors();
    Profesor updateProfesor(Long id, Profesor Profesor);
    void deleteProfesor(Long id);
}