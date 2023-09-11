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
import com.olpasa.model.Vehiculo;
import com.olpasa.service.IVehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping
	public ResponseEntity<List<Vehiculo>> listar(){
		List<Vehiculo> listrarVehiculo = vehiculoService.listar();
		return new ResponseEntity<List<Vehiculo>>(listrarVehiculo, HttpStatus.OK);
	}
	
	@GetMapping("/{id_sector}")
	public ResponseEntity<Vehiculo> leerPorId(@PathVariable("id_sector") Integer id_sector){
		Vehiculo sectorId = vehiculoService.leerPorId(id_sector);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_sector);
		}
		return new ResponseEntity<Vehiculo>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Vehiculo sec) {
		Vehiculo sector = vehiculoService.registrar(sec);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sec.getId_vehiculo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Vehiculo sec) {
		vehiculoService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
