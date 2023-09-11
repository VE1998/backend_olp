package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Parcela;
import com.olpasa.repo.IParcelaRepo;
import com.olpasa.service.IParcelaService;

@Service
public class ParcelaServiceImpl implements IParcelaService{

	@Autowired
	private IParcelaRepo parcelaRepo;

	@Override
	public Parcela registrar(Parcela sec) {
		return parcelaRepo.save(sec);
	}

	@Override
	public Parcela modificar(Parcela sec) {
		return parcelaRepo.save(sec);
	}

	@Override
	public Parcela leerPorId(Integer id) {
		return parcelaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Parcela> listar() {
		return parcelaRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
