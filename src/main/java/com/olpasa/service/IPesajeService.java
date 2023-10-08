package com.olpasa.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.olpasa.model.Pesaje;

public interface IPesajeService extends ICRUD<Pesaje>{
	
	
	List<Pesaje> listarPorEstado(String estado);
}
