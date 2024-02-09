package org.health.healthcheck.persistence.crud;


import org.health.healthcheck.persistence.entity.Usuario;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    //Calculate imc method
    @Query(value = "SELECT 10000*peso/(talla*talla) AS imc " +
            "FROM USUARIOS " +
            "WHERE id_usuario = :userId", nativeQuery = true)
    UserProjection getImc(@Param("userId") int userId);

    //Calculate age method
    ////In mysql
    /*@Query(value = "SELECT YEAR(CURDATE())-YEAR(`USUARIOS`.`fecha_nacimiento`) " +
            "IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(`USUARIOS`.`fecha_nacimiento`,'%m-%d'), 0 , -1 ) AS `currentAge`" +
            "FROM `USUARIOS` WHERE id_usuario =: idUser;", nativeQuery = true)
    UserProjection getCurrentAge(@Param("idUser") int idUser);*/

    ////In postgresql
    @Query(value = "SELECT TO_CHAR(AGE(fecha_nacimiento), 'YY \"Años\" mm \"Meses\" DD \"Días\"') " +
            "AS currentAge " +
            "FROM USUARIOS WHERE id_usuario = :userId", nativeQuery = true)
    UserProjection getCurrentAge(@Param("userId") int userId);

}
