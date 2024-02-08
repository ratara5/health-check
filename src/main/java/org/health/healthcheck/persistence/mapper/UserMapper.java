package org.health.healthcheck.persistence.mapper;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel ="spring") //uses = {CategoryMapper.class}
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "tipoId", target = "typeId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "peso", target = "weight"),
            @Mapping(source = "talla", target = "height"),
            @Mapping(source = "imc", target = "imc"),
            @Mapping(source = "edadActual", target = "currentAge"),
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> users);

    @InheritInverseConfiguration
    //@Mapping(target = "tipoId", ignore = true)
    Usuario toUsuario(User user);

}
