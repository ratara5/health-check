package org.health.healthcheck.persistence.crud;


import org.health.healthcheck.persistence.entity.Usuario;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.health.healthcheck.persistence.entity.UsuarioPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, UsuarioPK> {



    Optional<Usuario> findById_TipoIdAndId_IdUsuario(String typeId, String userId);

    void deleteById_TipoIdAndId_IdUsuario(String typeId, String userId);



    //Calculate age method
    ////In mysql
    /*@Query(value = "SELECT YEAR(CURDATE())-YEAR(`USUARIOS`.`fecha_nacimiento`) " +
            "IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(`USUARIOS`.`fecha_nacimiento`,'%m-%d'), 0 , -1 ) AS `currentAge`" +
            "FROM `USUARIOS` WHERE id_usuario =: idUser;", nativeQuery = true)
    UserProjection getCurrentAge(@Param("idUser") int idUser);*/

    ////In postgresql
    @Query(value = "SELECT TO_CHAR(AGE(fecha_nacimiento), 'YY \"Años\" mm \"Meses\" DD') " +
            "AS currentAge " +
            "FROM USUARIOS " +
            "WHERE tipo_id = :typeId AND id_usuario = :userId", nativeQuery = true)
    UserProjection getCurrentAge(@Param("typeId") String typeId,
                                 @Param("userId") String userId);

}
