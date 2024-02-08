package org.health.healthcheck.persistence.entity;

public interface UserProjection {

    Long getIdUser();
    float getImc();

    int getCurrentAge();

}
