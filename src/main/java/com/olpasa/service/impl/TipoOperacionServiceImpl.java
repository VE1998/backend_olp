package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.TipoOperacion;
import com.olpasa.repo.ITipoOperacionRepo;
import com.olpasa.service.ITipoOperacionService;

@Service
public class TipoOperacionServiceImpl implements ITipoOperacionService{

	@Autowired
	private ITipoOperacionRepo tipoOperacionRepo;
	
	@Override
	public TipoOperacion registrar(TipoOperacion to) {
		return tipoOperacionRepo.save(to);
	}

	@Override
	public TipoOperacion modificar(TipoOperacion to) {
		return tipoOperacionRepo.save(to);
	}

	@Override
	public TipoOperacion leerPorId(Integer id) {
		return tipoOperacionRepo.findById(id).orElse(null);
	}

	@Override
	public List<TipoOperacion> listar() {
		return tipoOperacionRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
