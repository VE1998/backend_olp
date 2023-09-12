package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

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
	public EvaluacionCalidad registrar(EvaluacionCalidad sec) {
		return evaluacionCalidadRepo.save(sec);
	}

	@Override
	public EvaluacionCalidad modificar(EvaluacionCalidad sec) {
		return evaluacionCalidadRepo.save(sec);
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
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
