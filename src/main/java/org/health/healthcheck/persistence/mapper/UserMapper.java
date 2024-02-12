package org.health.healthcheck.persistence.mapper;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring", uses={MeasureMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id.idUsuario", target = "userId"),
            @Mapping(source = "id.tipoId", target = "typeId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "medidas", target = "measures"),
            @Mapping(source = "edadActual", target = "currentAge"),
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> users);

    @InheritInverseConfiguration
    //@Mapping(target = "tipoId", ignore = true)
    Usuario toUsuario(User user);

}