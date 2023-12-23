package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.CuentaBancaria;
import com.olpasa.repo.ICuentaBancariaRepo;
import com.olpasa.service.ICuentaBancariaService;


@Service
public class CuentaBancariaSericeImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public CuentaBancaria registrar(CuentaBancaria cb) {
		return cuentaBancariaRepo.save(cb);
	}

	@Override
	public CuentaBancaria modificar(CuentaBancaria cb) {
		return cuentaBancariaRepo.save(cb);
	}

	@Override
	public CuentaBancaria leerPorId(Integer id) {
		return cuentaBancariaRepo.findById(id).orElse(null);
	}

	@Override
	public List<CuentaBancaria> listar() {
		return cuentaBancariaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {

	}

	
}
