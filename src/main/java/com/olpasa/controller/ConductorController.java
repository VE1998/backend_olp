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
import com.olpasa.model.Conductor;
import com.olpasa.service.IConductorService;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

	
	@Autowired
	private IConductorService conductorService;
	
	@GetMapping
	public ResponseEntity<List<Conductor>> listar(){
		List<Conductor> listrarConductor = conductorService.listar();
		return new ResponseEntity<List<Conductor>>(listrarConductor, HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Conductor> leerPorId(@PathVariable("codigo") Integer codigo){
		Conductor conductorId = conductorService.leerPorId(codigo);
		if(conductorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo);
		}
		return new ResponseEntity<Conductor>(conductorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Conductor> registrar (@RequestBody Conductor cond) {
		Conductor conductor = conductorService.registrar(cond);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cond.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Conductor> modificar (@RequestBody Conductor sec) {
		conductorService.modificar(sec);
		return new ResponseEntity<Conductor>(HttpStatus.OK);
	}
	
}
