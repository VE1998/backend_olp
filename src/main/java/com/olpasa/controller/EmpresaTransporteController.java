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
import com.olpasa.model.EmpresaTransporte;
import com.olpasa.service.IEmpresaTransporteService;


@RestController
@RequestMapping("/empresaTransporte")
public class EmpresaTransporteController {

	@Autowired
	private IEmpresaTransporteService empresaTransporteService;
	
	@GetMapping
	public ResponseEntity<List<EmpresaTransporte>> listar(){
		List<EmpresaTransporte> listrarEmpresaTransporte = empresaTransporteService.listar();
		return new ResponseEntity<List<EmpresaTransporte>>(listrarEmpresaTransporte, HttpStatus.OK);
	}
	
	@GetMapping("/{codigo_et}")
	public ResponseEntity<EmpresaTransporte> leerPorId(@PathVariable("codigo_et") Integer codigo_et){
		EmpresaTransporte sectorId = empresaTransporteService.leerPorId(codigo_et);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ codigo_et);
		}
		return new ResponseEntity<EmpresaTransporte>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody EmpresaTransporte et) {
		EmpresaTransporte sector = empresaTransporteService.registrar(et);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(et.getCodigo_et()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody EmpresaTransporte sec) {
		empresaTransporteService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
