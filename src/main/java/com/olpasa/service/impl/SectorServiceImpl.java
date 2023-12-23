package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Sector;
import com.olpasa.repo.ISectorRepo;
import com.olpasa.service.ISectorService;

@Service
public class SectorServiceImpl implements ISectorService{

	@Autowired
	private ISectorRepo sectorRepo;

	@Override
	public Sector registrar(Sector sec) {
		return sectorRepo.save(sec);
	}

	@Override
	public Sector modificar(Sector sec) {
		return sectorRepo.save(sec);
	}

	@Override
	public Sector leerPorId(Integer id) {
		return sectorRepo.findById(id).orElse(null);
	}

	@Override
	public List<Sector> listar() {
		return sectorRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
