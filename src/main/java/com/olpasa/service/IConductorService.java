package com.olpasa.service;

import java.util.List;

import com.olpasa.model.Conductor;


public interface IConductorService extends ICRUD<Conductor>{

	List<Conductor> leerPorEstado(String estado);
	
}
