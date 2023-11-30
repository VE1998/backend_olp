package com.olpasa.service;

import com.olpasa.model.EvaluacionCalidad;

import java.util.List;

public interface IEvaluacionCalidadService extends ICRUD<EvaluacionCalidad>{

    List<EvaluacionCalidad> listarPorIdPesaje(Integer id_pesaje);

}
