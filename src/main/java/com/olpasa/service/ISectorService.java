package com.olpasa.service;

import java.util.List;
import java.util.Optional;

import com.olpasa.model.Sector;


public interface ISectorService {

	void registrar(Sector sec);
	void modificar(Sector sec);
	List<Sector> listar();
	Optional<Sector> leerPord(Integer id);
	void eliminar(Integer id);
}
