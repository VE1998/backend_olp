package com.olpasa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;

@RestController
@RequestMapping("/sectores")
public class SectorController {

	@Autowired
	private ISectorService sectorService;
	
	@GetMapping
	public ResponseEntity<List<Sector>> listar(){
		List<Sector> listrarSector = sectorService.listar();
		return new ResponseEntity<List<Sector>>(listrarSector, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<Sector> leerPorId(@PathVariable("id_sector") Integer id_sector){
		Sector sectorId = sectorService.leerPorId(id_sector);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_sector);
		}
		return new ResponseEntity<Sector>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Sector> registrar (@RequestBody Sector sec) {
		Sector sector = sectorService.registrar(sec);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sec.getId_sector()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Sector sec) {
		sectorService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
