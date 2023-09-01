package com.olpasa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;

@RestController
@RequestMapping("/sectores")
public class SectorController {

	@Autowired
	private ISectorService sectorService;
	
	@GetMapping
	public List<Sector> listar(){
		return sectorService.listar();
	}
	
	@GetMapping("/{id_sector}")
	public Optional<Sector> leerPorId(@PathVariable("id_sector") Integer id_sector){
		return sectorService.leerPord(id_sector);
	}
	
	@PostMapping
	public void registrar (@RequestBody Sector sec) {
		sectorService.registrar(sec);
	}
	
	@PutMapping
	public void modificar (@RequestBody Sector sec) {
		sectorService.modificar(sec);
	}
	
	
}
