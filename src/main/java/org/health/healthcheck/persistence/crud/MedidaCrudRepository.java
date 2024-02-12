package org.health.healthcheck.persistence.crud;

import org.antlr.v4.runtime.misc.MultiMap;
import org.health.healthcheck.persistence.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MedidaCrudRepository extends CrudRepository<Medida, MedidaPK> {

    //Calculate imc method
    @Query(value = "SELECT id_medida AS measureId, ROUND(CAST(10000*peso/(talla*talla) AS numeric), 2) AS imc " +
            "FROM MEDIDAS " +
            "WHERE tipo_id = :typeId AND id_usuario = :userId", nativeQuery = true)
    List<MeasureProjection> getImcs(@Param("typeId") String typeId,
                             @Param("userId") String userId);



    /*@Query("SELECT medida " +
            "FROM Medida medida " +
            "WHERE medida.usuario.tipoId = :typeId AND medida.usuario.idUsuario = :userId")*/
    @Query(value = "SELECT * " +
    "FROM MEDIDAS " +
    "WHERE tipo_id = :typeId and id_usuario = :userId", nativeQuery = true)
    Optional<List<Medida>> getByTipoIdAndIdUsuario(@Param("typeId") String typeId,
                                                    @Param("userId") String userId);
}
