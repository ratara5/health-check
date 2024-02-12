package org.health.healthcheck.domain.service;


import org.health.healthcheck.domain.Measure;
import org.health.healthcheck.domain.repository.MeasureRepository;
import org.health.healthcheck.persistence.entity.MeasureProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasureService {

    @Autowired
    private MeasureRepository measureRepository;

    public Optional<List<Measure>> getMeasures(String typeId, String userId){
        return measureRepository.getMeasures(typeId, userId);
    }

    public List<MeasureProjection> getImcs(String typeId, String userId) {
        return measureRepository.getImcs(typeId, userId);
    }

    public Optional<List<Measure>> getByUser(String typeId, String userId) {
        return measureRepository.getByUser(typeId, userId);
    }

}
