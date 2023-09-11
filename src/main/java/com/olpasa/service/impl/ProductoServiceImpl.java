package com.olpasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Producto;
import com.olpasa.repo.IProductoRepo;
import com.olpasa.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public Producto registrar(Producto pro) {
		return productoRepo.save(pro);
	}

	@Override
	public Producto modificar(Producto pro) {
		return productoRepo.save(pro);
	}

	@Override
	public Producto leerPorId(Integer id) {
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listar() {
		return productoRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}
	
	
	
}
