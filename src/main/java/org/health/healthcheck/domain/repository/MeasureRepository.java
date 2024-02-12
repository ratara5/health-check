package org.health.healthcheck.domain.repository;


import org.health.healthcheck.domain.Measure;
import org.health.healthcheck.persistence.entity.MeasureProjection;

import java.util.List;
import java.util.Optional;

public interface MeasureRepository {

    List<MeasureProjection> getImcs(String typeId, String userId);

    Optional<List<Measure>> getMeasures(String typeId, String userId);

    Optional<List<Measure>> getByUser(String typeId, String userId);

}