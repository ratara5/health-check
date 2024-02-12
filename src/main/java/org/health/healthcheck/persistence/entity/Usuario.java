package org.health.healthcheck.persistence.entity;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @EmbeddedId
    private UsuarioPK id;
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;


    @OneToMany(mappedBy = "usuario")
    private List<Medida> medidas;

    @Transient
    private String edadActual;



    public UsuarioPK getId() {
        return id;
    }

    public void setId(UsuarioPK id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }

    public String getEdadActual() {
        return edadActual;
    }

    public void setEdadActual(String edadActual) {
        this.edadActual = edadActual;
    }



}
