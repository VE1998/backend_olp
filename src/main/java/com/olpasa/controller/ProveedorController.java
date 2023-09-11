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
import com.olpasa.model.Proveedor;
import com.olpasa.service.IProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> listar(){
		List<Proveedor> listrarProveedor = proveedorService.listar();
		return new ResponseEntity<List<Proveedor>>(listrarProveedor, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<Proveedor> leerPorId(@PathVariable("codigo") Integer codigo){
		Proveedor sectorId = proveedorService.leerPorId(codigo);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo);
		}
		return new ResponseEntity<Proveedor>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Proveedor pro) {
		Proveedor sector = proveedorService.registrar(pro);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pro.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Proveedor sec) {
		proveedorService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
