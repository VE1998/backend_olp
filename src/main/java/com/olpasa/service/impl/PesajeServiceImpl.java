package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Pesaje;
import com.olpasa.repo.IPesajeRepo;
import com.olpasa.service.IPesajeService;

@Service
public class PesajeServiceImpl implements IPesajeService{

	@Autowired
	private IPesajeRepo pesajerRepo;

	@Override
	public Pesaje registrar(Pesaje sec) {
		return pesajerRepo.save(sec);
	}

	@Override
	public Pesaje modificar(Pesaje sec) {
		return pesajerRepo.save(sec);
	}

	@Override
	public Pesaje leerPorId(Integer id) {
		return pesajerRepo.findById(id).orElse(null);
	}

	@Override
	public List<Pesaje> listar() {
		return pesajerRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
