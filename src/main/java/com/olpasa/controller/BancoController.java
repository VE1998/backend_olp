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
import com.olpasa.model.Banco;
import com.olpasa.service.IBancoService;

@RestController
@RequestMapping("bancos")
public class BancoController {

	@Autowired
	private IBancoService bancoService;
	
	@GetMapping
	public ResponseEntity<List<Banco>> listar(){
		List<Banco> listrarBanco = bancoService.listar();
		return new ResponseEntity<List<Banco>>(listrarBanco, HttpStatus.OK);
	}
	
	@GetMapping("/{id_banco}")
	public ResponseEntity<Banco> leerPorId(@PathVariable("id_banco") Integer id_banco){
		Banco buscarPorId = bancoService.leerPorId(id_banco);
		if(buscarPorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_banco);
		}
		return new ResponseEntity<Banco>(buscarPorId, HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Banco ban) {
		Banco banco = bancoService.registrar(ban);
		//localhost:8080/bantor/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ban.getId_banco()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Banco ban) {
		bancoService.modificar(ban);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
