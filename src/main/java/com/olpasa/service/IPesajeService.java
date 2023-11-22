package com.olpasa.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olpasa.model.Pesaje;


public interface IPesajeService extends ICRUD<Pesaje>{
	
	
	List<Pesaje> listarPorEstado();
	
	List<Pesaje> listarPorOperacion(Integer estado);
	
	List<Pesaje> listarPorCodProducto(Integer estado);
}
