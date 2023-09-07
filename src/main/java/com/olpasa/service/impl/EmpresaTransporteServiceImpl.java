package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.EmpresaTransporte;
import com.olpasa.repo.IEmpresaTransporteRepo;
import com.olpasa.service.IEmpresaTransporteService;

@Service
public class EmpresaTransporteServiceImpl implements IEmpresaTransporteService{

	@Autowired
	private IEmpresaTransporteRepo empresaTransporteService;
	
	@Override
	public EmpresaTransporte registrar(EmpresaTransporte et) {
		return empresaTransporteService.save(et);
	}

	@Override
	public EmpresaTransporte modificar(EmpresaTransporte et) {
		return empresaTransporteService.save(et);
	}

	@Override
	public EmpresaTransporte leerPorId(Integer id) {
		return empresaTransporteService.findById(id).orElse(null);
	}

	@Override
	public List<EmpresaTransporte> listar() {
		return empresaTransporteService.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
