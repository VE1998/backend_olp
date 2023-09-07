package com.olpasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Persona;
import com.olpasa.repo.IPersonaRepo;
import com.olpasa.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo personaRepo;
	
	
	@Override
	public Persona registrar(Persona per) {
		return personaRepo.save(per);
	}

	@Override
	public Persona modificar(Persona per) {
		return personaRepo.save(per);
	}

	@Override
	public Persona leerPorId(Integer id) {
		return personaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Persona> listar() {
		return personaRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
