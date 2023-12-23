package com.olpasa.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.UnidadMedida;
import com.olpasa.repo.IUnidadMedidaRepo;
import com.olpasa.service.IUnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements IUnidadMedidaService{

	@Autowired
	private IUnidadMedidaRepo unidadMediaRepo;

	@Override
	public UnidadMedida registrar(UnidadMedida um) {
		return unidadMediaRepo.save(um);
	}

	@Override
	public UnidadMedida modificar(UnidadMedida um) {
		return unidadMediaRepo.save(um);
	}

	@Override
	public UnidadMedida leerPorId(Integer id) {
		return unidadMediaRepo.findById(id).orElse(null);
	}

	@Override
	public List<UnidadMedida> listar() {
		return unidadMediaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
