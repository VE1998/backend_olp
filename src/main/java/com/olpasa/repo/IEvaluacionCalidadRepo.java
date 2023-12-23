package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.EvaluacionCalidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEvaluacionCalidadRepo extends JpaRepository<EvaluacionCalidad, Integer>{

    @Query(value = "SELECT * FROM evaluacion_calidad e where e.id_pesaje= :id_pesaje", nativeQuery = true)
    List<EvaluacionCalidad> listarPorIdPesaje(@Param("id_pesaje") Integer id_pesaje);


}
