package com.olpasa.service;

import java.math.BigDecimal;
import java.util.List;

import com.olpasa.model.Pesaje;


public interface IPesajeService extends ICRUD<Pesaje>{
	
	
	List<Pesaje> listarPorEstado();

	int updatePlanilla(BigDecimal castigo, Integer id_pesaje) throws Exception;

	int updateImporte(BigDecimal castigo, Integer id_pesaje) throws Exception;
	

}
