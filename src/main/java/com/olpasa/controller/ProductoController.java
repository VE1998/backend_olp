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
import com.olpasa.model.Producto;
import com.olpasa.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> listrarProducto = productoService.listar();
		return new ResponseEntity<List<Producto>>(listrarProducto, HttpStatus.OK);
	}
	
	@GetMapping("/{cod_producto}")
	public ResponseEntity<Producto> leerPorId(@PathVariable("cod_producto") Integer cod_producto){
		Producto sectorId = productoService.leerPorId(cod_producto);
		if(sectorId == null) {
			throw new ModelNotFoundException("Id no Encontrado: "+ cod_producto);
		}
		return new ResponseEntity<Producto>(sectorId, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar (@RequestBody Producto pro) {
		Producto productos = productoService.registrar(pro);
		//localhost:8080/sector/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pro.getCod_producto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar (@RequestBody Producto pro) {
		productoService.modificar(pro);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
