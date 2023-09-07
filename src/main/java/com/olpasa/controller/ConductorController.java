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
	private IConductorService sectorService;
	
	@GetMapping
	public ResponseEntity<List<Conductor>> listar(){
		List<Conductor> listrarConductor = sectorService.listar();
		return new ResponseEntity<List<Conductor>>(listrarConductor, HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Conductor> leerPorId(@PathVariable("codigo") Integer codigo){
		Conductor sectorId = sectorService.leerPorId(codigo);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo);
		}
		return new ResponseEntity<Conductor>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Conductor sec) {
		Conductor sector = sectorService.registrar(sec);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sec.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Conductor sec) {
		sectorService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
