package org.health.healthcheck.persistence.crud;


import org.health.healthcheck.persistence.entity.Usuario;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    //List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Calculate imc method
    @Query(value = "SELECT peso/(talla*talla/10000) AS imc " +
            "FROM USUARIOS " +
            "WHERE id_usuario = :idUser;", nativeQuery = true)
    UserProjection getImc(@Param("idUser") int idUser);

    //Calculate age method
    ////In mysql
    /*@Query(value = "SELECT YEAR(CURDATE())-YEAR(`USUARIOS`.`fecha_nacimiento`) " +
            "IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(`USUARIOS`.`fecha_nacimiento`,'%m-%d'), 0 , -1 ) AS `currentAge`" +
            "FROM `USUARIOS` WHERE id_usuario =: idUser;", nativeQuery = true)
    UserProjection getCurrentAge(@Param("idUser") int idUser);*/

    ////In postgresql
    @Query(value = "SELECT AGE(fecha_nacimiento) " +
            "AS currentAge " +
            "FROM USUARIOS WHERE id_usuario = :idUser;", nativeQuery = true)
    UserProjection getCurrentAge(@Param("idUser") int idUser);
}
