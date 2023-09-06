package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.ClasificacionContable;
import com.olpasa.repo.IClasificacionContableRepo;
import com.olpasa.service.IClasificacionContableService;

@Service
public class ClasificacionContableServiceImpl implements IClasificacionContableService{

	@Autowired
	private IClasificacionContableRepo clasContRepo;
	
	@Override
	public ClasificacionContable registrar(ClasificacionContable clasc) {
		return clasContRepo.save(clasc);
	}

	@Override
	public ClasificacionContable modificar(ClasificacionContable clasc) {
		return clasContRepo.save(clasc);
	}

	@Override
	public ClasificacionContable leerPorId(Integer id) {
		return clasContRepo.findById(id).orElse(null);
	}

	@Override
	public List<ClasificacionContable> listar() {
		return clasContRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
