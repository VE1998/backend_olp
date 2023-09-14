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
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.service.IEvaluacionCalidadService;

@RestController
@RequestMapping("/evaluacioncalidades")
public class EvaluacionCalidadController {

	@Autowired
	private IEvaluacionCalidadService evaluacionCalidadService;
	
	@GetMapping
	public ResponseEntity<List<EvaluacionCalidad>> listar(){
		List<EvaluacionCalidad> listrarEvaluacionCalidad = evaluacionCalidadService.listar();
		return new ResponseEntity<List<EvaluacionCalidad>>(listrarEvaluacionCalidad, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<EvaluacionCalidad> leerPorId(@PathVariable("id_sector") Integer id_sector){
		EvaluacionCalidad sectorId = evaluacionCalidadService.leerPorId(id_sector);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_sector);
		}
		return new ResponseEntity<EvaluacionCalidad>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EvaluacionCalidad> registrar (@RequestBody EvaluacionCalidad ev) {
		EvaluacionCalidad evaluacionCalidad = evaluacionCalidadService.registrar(ev);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ev.getId_evaluacion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody EvaluacionCalidad sec) {
		evaluacionCalidadService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
