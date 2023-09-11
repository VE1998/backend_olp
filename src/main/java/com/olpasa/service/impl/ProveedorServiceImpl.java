package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Proveedor;
import com.olpasa.repo.IProveedorRepo;
import com.olpasa.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorRepo proveedorRepo;

	@Override
	public Proveedor registrar(Proveedor pro) {
		return proveedorRepo.save(pro);
	}

	@Override
	public Proveedor modificar(Proveedor pro) {
		return proveedorRepo.save(pro);
	}

	@Override
	public Proveedor leerPorId(Integer id) {
		return proveedorRepo.findById(id).orElse(null);
	}

	@Override
	public List<Proveedor> listar() {
		return proveedorRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
