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
import com.olpasa.model.Parcela;
import com.olpasa.service.IParcelaService;

@RestController
@RequestMapping("/parcelas")
public class ParcelaController {

	@Autowired
	private IParcelaService parcelaService;
	
	@GetMapping
	public ResponseEntity<List<Parcela>> listar(){
		List<Parcela> listrarParcela = parcelaService.listar();
		return new ResponseEntity<List<Parcela>>(listrarParcela, HttpStatus.OK);
	}
	
	@GetMapping("/{id_parcela}")
	public ResponseEntity<Parcela> leerPorId(@PathVariable("id_parcela") Integer id_parcela){
		Parcela sectorId = parcelaService.leerPorId(id_parcela);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_parcela);
		}
		return new ResponseEntity<Parcela>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Parcela par) {
		Parcela parcela = parcelaService.registrar(par);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(par.getId_parcela()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Parcela sec) {
		parcelaService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
