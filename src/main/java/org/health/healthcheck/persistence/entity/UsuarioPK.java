package org.health.healthcheck.persistence.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class UsuarioPK implements Serializable {

    @Column(name="tipo_id")
    private String tipoId;

    @Column(name = "id_usuario")
    private String idUsuario;

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
