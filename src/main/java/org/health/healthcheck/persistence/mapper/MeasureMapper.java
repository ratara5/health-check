package org.health.healthcheck.persistence.mapper;


import org.health.healthcheck.domain.Measure;
import org.health.healthcheck.persistence.entity.Medida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring") //uses = {UserMapper.class}
public interface MeasureMapper {

    @Mappings({
            @Mapping(source = "id.idMedida", target = "measureId"),
            @Mapping(source = "id.fechaToma", target = "collectionDate"),
            @Mapping(source = "peso", target = "weight"),
            @Mapping(source = "talla", target = "height"),
            @Mapping(source = "imc", target = "imc"),
    })
    Measure toMeasure(Medida medida);
    List<Measure> toMeasures(List<Medida> Measure);

    @InheritInverseConfiguration
    //@Mapping(target = "tipoId", ignore = true)
    Medida toMedida(Measure measure);

}