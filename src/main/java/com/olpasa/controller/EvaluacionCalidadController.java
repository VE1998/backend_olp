package com.olpasa.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	public ResponseEntity<Object> registrar (@RequestBody EvaluacionCalidad ev) {
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

	@GetMapping("/destarar/{id_pesaje}")
	public ResponseEntity<List<EvaluacionCalidad>> leerPorIdPesaje(@PathVariable("id_pesaje") Integer id_pesaje){
		List<EvaluacionCalidad> evaluacionLista = new ArrayList<>();
		evaluacionLista = evaluacionCalidadService.listarPorIdPesaje(id_pesaje);
		return new ResponseEntity<List<EvaluacionCalidad>>(evaluacionLista, HttpStatus.OK);
	}

	@DeleteMapping("/{id_evaluacion}")
	public ResponseEntity<Object>  eliminar(@PathVariable("id_evaluacion") Integer id_evaluacion) {
		EvaluacionCalidad obj = evaluacionCalidadService.leerPorId(id_evaluacion);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id_evaluacion);
		}else {
			evaluacionCalidadService.eliminar(id_evaluacion);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
}
