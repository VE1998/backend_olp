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
import com.olpasa.model.TipoOperacion;
import com.olpasa.service.ITipoOperacionService;
import com.olpasa.service.ITipoOperacionService;

@RestController
@RequestMapping("/tipoOperaciones")
public class TipoOperacionController {

	
	@Autowired
	private ITipoOperacionService tipoOperacionService;
	
	@GetMapping
	public ResponseEntity<List<TipoOperacion>> listar(){
		List<TipoOperacion> listrarTipoOperacion = tipoOperacionService.listar();
		return new ResponseEntity<List<TipoOperacion>>(listrarTipoOperacion, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<TipoOperacion> leerPorId(@PathVariable("id_sector") Integer id_to){
		TipoOperacion sectorId = tipoOperacionService.leerPorId(id_to);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_to);
		}
		return new ResponseEntity<TipoOperacion>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody TipoOperacion sec) {
		TipoOperacion sector = tipoOperacionService.registrar(sec);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sec.getId_to()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody TipoOperacion sec) {
		tipoOperacionService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
