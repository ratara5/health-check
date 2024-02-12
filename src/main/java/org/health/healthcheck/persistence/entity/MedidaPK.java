package org.health.healthcheck.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class MedidaPK implements Serializable {

    @Column(name="id_medida")
    private Integer idMedida;

    @Column(name = "fecha_toma")
    private LocalDate fechaToma;

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public LocalDate getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(LocalDate fechaToma) {
        this.fechaToma = fechaToma;
    }
}
