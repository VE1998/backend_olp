package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Conductor;
import com.olpasa.repo.IConductorRepo;
import com.olpasa.service.IConductorService;

@Service
public class ConductorServiceImpl implements IConductorService{

	@Autowired
	private IConductorRepo conductorRepo;
	
	@Override
	public Conductor registrar(Conductor con) {
		return conductorRepo.save(con);
	}

	@Override
	public Conductor modificar(Conductor con) {
		return conductorRepo.save(con);
	}

	@Override
	public Conductor leerPorId(Integer id) {
		return conductorRepo.findById(id).orElse(null);
	}

	@Override
	public List<Conductor> listar() {
		return conductorRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
