package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.CriterioCalidad;
import com.olpasa.repo.ICriterioCalidadRepo;
import com.olpasa.repo.ICriterioCalidadRepo;
import com.olpasa.service.ICriterioCalidadService;

@Service
public class CriterioCalidadServiceImpl implements ICriterioCalidadService{

	@Autowired
	private ICriterioCalidadRepo criterioCalidadRepo;

	@Override
	public CriterioCalidad registrar(CriterioCalidad cr) {
		return criterioCalidadRepo.save(cr);
	}

	@Override
	public CriterioCalidad modificar(CriterioCalidad cr) {
		return criterioCalidadRepo.save(cr);
	}

	@Override
	public CriterioCalidad leerPorId(Integer id) {
		return criterioCalidadRepo.findById(id).orElse(null);
	}

	@Override
	public List<CriterioCalidad> listar() {
		return criterioCalidadRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
