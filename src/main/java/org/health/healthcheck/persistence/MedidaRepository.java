package org.health.healthcheck.persistence;


import org.health.healthcheck.domain.Measure;
import org.health.healthcheck.domain.User;
import org.health.healthcheck.persistence.mapper.MeasureMapper;
import org.health.healthcheck.domain.repository.MeasureRepository;
import org.health.healthcheck.domain.repository.UserRepository;
import org.health.healthcheck.persistence.crud.MedidaCrudRepository;
import org.health.healthcheck.persistence.crud.UsuarioCrudRepository;
import org.health.healthcheck.persistence.entity.MeasureProjection;
import org.health.healthcheck.persistence.entity.Medida;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.health.healthcheck.persistence.entity.Usuario;
import org.health.healthcheck.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class MedidaRepository implements MeasureRepository {

    @Autowired
    private MedidaCrudRepository medidaCrudRepository;

    @Autowired
    private MeasureMapper mapper;


    @Override
    public List<MeasureProjection> getImcs(String typeId, String userId) {
        return medidaCrudRepository.getImcs(typeId, userId);
    }

    @Override
    public Optional<List<Measure>> getMeasures(String typeId, String userId) {
        return medidaCrudRepository.getByTipoIdAndIdUsuario(typeId, userId).map(medidas -> mapper.toMeasures(medidas));
    }

    @Override
    public Optional<List<Measure>> getByUser(String typeId, String userId) {
        return medidaCrudRepository.getByTipoIdAndIdUsuario(typeId, userId)
                .map(medidas -> mapper.toMeasures(medidas));
    }


}
