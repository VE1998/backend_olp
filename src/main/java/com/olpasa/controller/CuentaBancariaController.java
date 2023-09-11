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
import com.olpasa.model.CuentaBancaria;
import com.olpasa.service.ICuentaBancariaService;


@RestController
@RequestMapping("/cuentabancaria")
public class CuentaBancariaController {

	@Autowired
	private ICuentaBancariaService cuentaBaciaService;
	
	@GetMapping
	public ResponseEntity<List<CuentaBancaria>> listar(){
		List<CuentaBancaria> listrarCuentaBancaria = cuentaBaciaService.listar();
		return new ResponseEntity<List<CuentaBancaria>>(listrarCuentaBancaria, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<CuentaBancaria> leerPorId(@PathVariable("id_cuenta") Integer id_cuenta){
		CuentaBancaria sectorId = cuentaBaciaService.leerPorId(id_cuenta);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_cuenta);
		}
		return new ResponseEntity<CuentaBancaria>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody CuentaBancaria cb) {
		CuentaBancaria sector = cuentaBaciaService.registrar(cb);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cb.getId_cuenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody CuentaBancaria sec) {
		cuentaBaciaService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
