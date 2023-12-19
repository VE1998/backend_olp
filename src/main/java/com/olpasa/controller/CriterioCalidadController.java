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
import com.olpasa.model.CriterioCalidad;
import com.olpasa.service.ICriterioCalidadService;
import com.olpasa.service.ICriterioCalidadService;

@RestController
@RequestMapping("/criterio_calidades")
public class CriterioCalidadController {

	@Autowired
	private ICriterioCalidadService criterioCalidadService;
	
	@GetMapping
	public ResponseEntity<List<CriterioCalidad>> listar(){
		List<CriterioCalidad> listrarCriterioCalidad = criterioCalidadService.listar();
		return new ResponseEntity<List<CriterioCalidad>>(listrarCriterioCalidad, HttpStatus.OK);
	}
	
	@GetMapping("/{id_criterio}")
	public ResponseEntity<CriterioCalidad> leerPorId(@PathVariable("id_criterio") Integer id_criterio){
		CriterioCalidad sectorId = criterioCalidadService.leerPorId(id_criterio);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_criterio);
		}
		return new ResponseEntity<CriterioCalidad>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody CriterioCalidad cr) {
		CriterioCalidad criterioCalidad = criterioCalidadService.registrar(cr);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cr.getId_criterio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody CriterioCalidad sec) {
		criterioCalidadService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
