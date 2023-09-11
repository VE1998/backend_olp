package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Vehiculo;
import com.olpasa.repo.IVehiculoRepo;
import com.olpasa.service.IVehiculoService;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepo vehiculoRepo;

	@Override
	public Vehiculo registrar(Vehiculo sec) {
		return vehiculoRepo.save(sec);
	}

	@Override
	public Vehiculo modificar(Vehiculo sec) {
		return vehiculoRepo.save(sec);
	}

	@Override
	public Vehiculo leerPorId(Integer id) {
		return vehiculoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Vehiculo> listar() {
		return vehiculoRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
