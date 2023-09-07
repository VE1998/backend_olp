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
import com.olpasa.model.UnidadMedida;
import com.olpasa.service.IUnidadMedidaService;

@RestController
@RequestMapping("/unidadMedidas")
public class UnidadMedidaController {

	@Autowired
	private IUnidadMedidaService unidadMedidaService;
	
	@GetMapping
	public ResponseEntity<List<UnidadMedida>> listar(){
		List<UnidadMedida> listrarUnidadMedida = unidadMedidaService.listar();
		return new ResponseEntity<List<UnidadMedida>>(listrarUnidadMedida, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<UnidadMedida> leerPorId(@PathVariable("id_sector") Integer codigo_um){
		UnidadMedida sectorId = unidadMedidaService.leerPorId(codigo_um);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo_um);
		}
		return new ResponseEntity<UnidadMedida>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody UnidadMedida um) {
		UnidadMedida sector = unidadMedidaService.registrar(um);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(um.getCodigo_um()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody UnidadMedida sec) {
		unidadMedidaService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
