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
	public Pesaje registrar(Pesaje pe) {
		return pesajerRepo.save(pe);
	}

	@Override
	public Pesaje modificar(Pesaje pe) {
		return pesajerRepo.save(pe);
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

	@Override
	public List<Pesaje> listarPorEstado() {
		return pesajerRepo.leerPorEstado();
	}

	@Override
	public List<Pesaje> listarPorOperacion(Integer id_to) {
		return pesajerRepo.leerPorTipoOperacion(id_to);
	}

	@Override
	public List<Pesaje> listarPorCodProducto(Integer cod_producto) {
		return pesajerRepo.leerPorProducto(cod_producto);
	}

	
	
	
		
	
}
