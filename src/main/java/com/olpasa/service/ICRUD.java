package com.olpasa.service;

import java.util.List;

import com.olpasa.model.Pesaje;

public interface ICRUD<T> {

	T registrar(T t);
	T modificar(T t);
	T leerPorId(Integer id);
	List<T> listar();
	void eliminar(Long id);
	
	
}
