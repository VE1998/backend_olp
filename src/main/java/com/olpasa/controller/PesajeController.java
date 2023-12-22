package com.olpasa.controller;

import java.math.BigDecimal;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
		List<Pesaje> listarPesaje = pesajeService.listar();
		return new ResponseEntity<List<Pesaje>>(listarPesaje, HttpStatus.OK);
	}
	
	@GetMapping("/{id_pesaje}")
	public ResponseEntity<Pesaje> leerPorId(@PathVariable("id_pesaje") Integer id_pesaje){
		Pesaje pesajeId = pesajeService.leerPorId(id_pesaje);
		if(pesajeId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ id_pesaje);
		}
		return new ResponseEntity<Pesaje>(pesajeId, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/destarar")
	public ResponseEntity<List<Pesaje>> listarPorEstado(){
	    List<Pesaje> listarPesaje = pesajeService.listarPorEstado();
	    return new ResponseEntity<List<Pesaje>>(listarPesaje, HttpStatus.OK);
	}


	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Pesaje sec) {
		pesajeService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Transactional
	@PutMapping("/updatePlanilla")
	public ResponseEntity<Object> updatePlanilla (@RequestBody Pesaje pesaje) throws Exception {
		pesajeService.updatePlanilla(pesaje.getCastigo_planilla(), pesaje.getId_pesaje());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Transactional
	@PutMapping("/updateImporte")
	public ResponseEntity<Object> updateImporte (@RequestBody Pesaje pesaje) throws Exception {
		pesajeService.updateImporte(pesaje.getCastigo_importe(), pesaje.getId_pesaje());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
