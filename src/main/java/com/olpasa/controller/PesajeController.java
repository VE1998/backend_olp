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
import com.olpasa.model.Pesaje;
import com.olpasa.service.IPesajeService;

@RestController
@RequestMapping("/pesajes")
public class PesajeController {

	@Autowired
	private IPesajeService pesajeService;
	
	@GetMapping
	public ResponseEntity<List<Pesaje>> listar(){
		List<Pesaje> listrarPesaje = pesajeService.listar();
		return new ResponseEntity<List<Pesaje>>(listrarPesaje, HttpStatus.OK);
	}
	
	@GetMapping("/{id_pesaje}")
	public ResponseEntity<Pesaje> leerPorId(@PathVariable("id_pesaje") Integer id_pesaje){
		Pesaje pesajeId = pesajeService.leerPorId(id_pesaje);
		if(pesajeId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_pesaje);
		}
		return new ResponseEntity<Pesaje>(pesajeId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Pesaje pes) {
		Pesaje sector = pesajeService.registrar(pes);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pes.getId_pesaje()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Pesaje sec) {
		pesajeService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
