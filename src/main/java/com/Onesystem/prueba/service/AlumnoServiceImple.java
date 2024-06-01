package com.Onesystem.prueba.service;

import com.Onesystem.prueba.model.Alumno;
import com.Onesystem.prueba.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImple implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno updateAlumno(Long id, Alumno alumno) {
        if (alumnoRepository.existsById(id)) {
            alumno.setId(id);
            return alumnoRepository.save(alumno);
        } else {
            throw new RuntimeException("Alumno no encontrado " + id);
        }
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}