package com.olpasa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.olpasa.exception.ModelNotFoundException;
import com.olpasa.model.Persona;
import com.olpasa.service.IPersonaService;
import com.olpasa.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> listrarPersona = personaService.listar();
		return new ResponseEntity<List<Persona>>(listrarPersona, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<Persona> leerPorId(@PathVariable("id_sector") Integer codigo){
		Persona sectorId = personaService.leerPorId(codigo);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo);
		}
		return new ResponseEntity<Persona>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Persona sec) {
		Persona sector = personaService.registrar(sec);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sec.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Persona sec) {
		personaService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
