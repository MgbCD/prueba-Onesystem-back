package com.Onesystem.prueba.model;


import com.Onesystem.prueba.service.Universidad;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Alumno extends Persona implements Universidad {

    @Column
    private String numeroMatricula;

    @Column
    private String programa;

    @Column
    private Double notaPromedio;


    @Override
    public void comer() {
    }

    @Override
    public void descansar() {

    }

    public void estudiar() {
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(Double notaPromedio) {
        this.notaPromedio = notaPromedio;
    }

    @Override
    public String obtenerHorario() {
        return "Horarios del alumno";
    }

    @Override
    public void irAClase() {
        System.out.println("El alumno va a ir la clase");
    }

    @Override
    public String obtenerPrograma() {
        return programa;
    }

    @Override
    public String obtenerPaseParqueadero() {
        return "Pase del parqueadero del alumnoi: " ;
    }
}
