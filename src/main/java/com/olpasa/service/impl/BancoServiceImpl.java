package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Banco;
import com.olpasa.repo.IBancoRepo;
import com.olpasa.service.IBancoService;

@Service
public class BancoServiceImpl implements IBancoService{

	@Autowired
	private IBancoRepo bancoRepo;
	
	@Override
	public Banco registrar(Banco ban) {
		return bancoRepo.save(ban);
	}

	@Override
	public Banco modificar(Banco ban) {	
		return bancoRepo.save(ban);
	}

	@Override
	public Banco leerPorId(Integer ban) {
		return bancoRepo.findById(ban).orElse(null);
	}

	@Override
	public List<Banco> listar() {
		return bancoRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
