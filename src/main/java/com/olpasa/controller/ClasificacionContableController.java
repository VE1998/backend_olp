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
import com.olpasa.model.ClasificacionContable;
import com.olpasa.model.ClasificacionContable;
import com.olpasa.service.IClasificacionService;
import com.olpasa.service.IClasificacionContableService;
import com.olpasa.service.IClasificacionContableService;

@RestController
@RequestMapping("/clasificacionContables")
public class ClasificacionContableController {

	
	@Autowired
	private IClasificacionContableService ClasificacionContableService;
	
	@GetMapping
	public ResponseEntity<List<ClasificacionContable>> listar(){
		List<ClasificacionContable> listrarClasificacionContable = ClasificacionContableService.listar();
		return new ResponseEntity<List<ClasificacionContable>>(listrarClasificacionContable, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<ClasificacionContable> leerPorId(@PathVariable("id_clasificacion") Integer id_clasificacion){
		ClasificacionContable clasificacionId = ClasificacionContableService.leerPorId(id_clasificacion);
		if(clasificacionId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_clasificacion);
		}
		return new ResponseEntity<ClasificacionContable>(clasificacionId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody ClasificacionContable clasCont) {
		ClasificacionContable sector = ClasificacionContableService.registrar(clasCont);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clasCont.getId_clasificacion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody ClasificacionContable clasCont) {
		ClasificacionContableService.modificar(clasCont);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
