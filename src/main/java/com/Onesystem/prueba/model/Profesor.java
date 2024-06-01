package com.Onesystem.prueba.model;


import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Profesor extends Persona{


    @Column
    private Double salario;

    @Column
    private String dependencia;

    @Column
    private String materia;



    @Override
    public void descansar() {

    }

    @Override
    public void comer() {

    }

    public void calificar() {

    }
    public void prepararClase() {

    }



    public double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public String getDependencia() {
        return dependencia;
    }
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }



}
