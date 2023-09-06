package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Clasificacion;
import com.olpasa.repo.IClasificacionRepo;
import com.olpasa.service.IClasificacionService;

@Service
public class ClasificacionServiceImpl implements IClasificacionService{

	@Autowired
	private IClasificacionRepo clasificacionRepo;
	
	@Override
	public Clasificacion registrar(Clasificacion clas) {
		return clasificacionRepo.save(clas);
	}

	@Override
	public Clasificacion modificar(Clasificacion clas) {
		return clasificacionRepo.save(clas);
	}

	@Override
	public Clasificacion leerPorId(Integer clas) {
		return clasificacionRepo.findById(clas).orElse(null);
	}

	@Override
	public List<Clasificacion> listar() {
		return clasificacionRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
