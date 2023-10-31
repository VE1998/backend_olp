package com.olpasa.controller;


import java.util.List;


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
	
	
	
	@GetMapping("/destarar/{estado}")
	public ResponseEntity<List<Pesaje>> listarPorEstado(@PathVariable("estado") String estado){
		List<Pesaje> listrarPesaje = pesajeService.listarPorEstado(estado);
		return new ResponseEntity<List<Pesaje>>(listrarPesaje, HttpStatus.OK);
	}
	
	@GetMapping("/operacion/{id_to}")
	public ResponseEntity<List<Pesaje>> listarPorOperacion(@PathVariable("id_to") Integer id_to){
		List<Pesaje> listrarPesaje = pesajeService.listarPorOperacion(id_to);
		return new ResponseEntity<List<Pesaje>>(listrarPesaje, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{cod_producto}")
	public ResponseEntity<List<Pesaje>> listarPorCodProducto(@PathVariable("cod_producto") Integer cod_producto){
		List<Pesaje> listrarPesaje = pesajeService.listarPorCodProducto(cod_producto);
		return new ResponseEntity<List<Pesaje>>(listrarPesaje, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Pesaje sec) {
		pesajeService.modificar(sec);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
