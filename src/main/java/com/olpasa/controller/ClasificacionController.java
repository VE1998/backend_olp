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
import com.olpasa.model.Clasificacion;
import com.olpasa.service.IClasificacionService;
import com.olpasa.service.IClasificacionService;

@RestController
@RequestMapping("/clasificaciones")
public class ClasificacionController {

	
	@Autowired
	private IClasificacionService clasificacionService;
	
	@GetMapping
	public ResponseEntity<List<Clasificacion>> listar(){
		List<Clasificacion> listrarClasificacion = clasificacionService.listar();
		return new ResponseEntity<List<Clasificacion>>(listrarClasificacion, HttpStatus.OK);
	}
	
	@GetMapping("/{id_clastor}")
	public ResponseEntity<Clasificacion> leerPorId(@PathVariable("id_clastor") Integer id_clas){
		Clasificacion clastorId = clasificacionService.leerPorId(id_clas);
		if(clastorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_clas);
		}
		return new ResponseEntity<Clasificacion>(clastorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Clasificacion clas) {
		Clasificacion clastor = clasificacionService.registrar(clas);
		//localhost:8080/clastor/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clas.getId_clas()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Clasificacion clas) {
		clasificacionService.modificar(clas);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
