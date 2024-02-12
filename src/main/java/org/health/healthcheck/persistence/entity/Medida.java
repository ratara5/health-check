package org.health.healthcheck.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

//This is the start point for historical-measures
@Entity
@Table(name = "MEDIDAS")
public class Medida {

    @EmbeddedId
    private MedidaPK id;

    private float peso;

    private Integer talla;

    @Transient
    private float imc;

    @ManyToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id")
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    public MedidaPK getId() {
        return id;
    }


    public void setId(MedidaPK id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }
}
