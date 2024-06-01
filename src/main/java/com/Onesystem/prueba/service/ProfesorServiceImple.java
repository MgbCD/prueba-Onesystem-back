package com.Onesystem.prueba.service;

import com.Onesystem.prueba.model.Profesor;
import com.Onesystem.prueba.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImple implements ProfesorService {

    @Autowired
    private ProfesorRepository ProfesorRepository;

    @Override
    public Profesor createProfesor(Profesor Profesor) {
        return ProfesorRepository.save(Profesor);
    }

    @Override
    public Optional<Profesor> getProfesorById(Long id) {
        return ProfesorRepository.findById(id);
    }
    @Override
    public List<Profesor> getAllProfesors() {
        return ProfesorRepository.findAll();
    }
    @Override
    public Profesor updateProfesor(Long id, Profesor Profesor) {
        if (ProfesorRepository.existsById(id)) {
            Profesor.setId(id);
            return ProfesorRepository.save(Profesor);
        } else {
            throw new RuntimeException("Profesor no encontrado " + id);
        }
    }
    @Override
    public void deleteProfesor(Long id) {
        ProfesorRepository.deleteById(id);
    }
}