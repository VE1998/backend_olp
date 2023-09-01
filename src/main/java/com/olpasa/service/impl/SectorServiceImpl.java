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
	public void registrar(Sector sec) {
		sectorRepo.save(sec);
		
	}

	@Override
	public void modificar(Sector sec) {
		sectorRepo.save(sec);
		
	}

	@Override
	public List<Sector> listar() {
		return sectorRepo.findAll();
	}

	@Override
	public Optional<Sector> leerPord(Integer id) {
		return sectorRepo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
