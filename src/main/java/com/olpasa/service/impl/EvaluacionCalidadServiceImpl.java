package com.olpasa.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.repo.IEvaluacionCalidadRepo;
import com.olpasa.service.IEvaluacionCalidadService;

@Service
public class EvaluacionCalidadServiceImpl implements IEvaluacionCalidadService{

	@Autowired
	private IEvaluacionCalidadRepo evaluacionCalidadRepo;

	@Override
	public EvaluacionCalidad registrar(EvaluacionCalidad ev) {
		return evaluacionCalidadRepo.save(ev);
	}

	@Override
	public EvaluacionCalidad modificar(EvaluacionCalidad ev) {
		return evaluacionCalidadRepo.save(ev);
	}

	@Override
	public EvaluacionCalidad leerPorId(Integer id) {
		return evaluacionCalidadRepo.findById(id).orElse(null);
	}

	@Override
	public List<EvaluacionCalidad> listar() {
		return evaluacionCalidadRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
       evaluacionCalidadRepo.deleteAllById(Collections.singleton(id));
	}

	@Override
	public List<EvaluacionCalidad> listarPorIdPesaje(Integer id_pesaje) {
		return evaluacionCalidadRepo.listarPorIdPesaje(id_pesaje);
	}
}
