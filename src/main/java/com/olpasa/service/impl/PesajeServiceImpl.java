package com.olpasa.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olpasa.model.Pesaje;
import com.olpasa.repo.IPesajeRepo;
import com.olpasa.service.IPesajeService;

@Service
public class PesajeServiceImpl implements IPesajeService{

	@Autowired
	private IPesajeRepo pesajerRepo;

	@Override
	public Pesaje registrar(Pesaje pe) {
		return pesajerRepo.save(pe);
	}

	@Override
	public Pesaje modificar(Pesaje pe) {
		return pesajerRepo.save(pe);
	}

	@Override
	public int updatePlanilla(BigDecimal castigo, Integer id_pesaje) throws Exception {
        return  pesajerRepo.updateCastigoPlanilla(castigo, id_pesaje);
    }

	@Override
	public int updateImporte(BigDecimal castigo, Integer id_pesaje) throws Exception {
		return  pesajerRepo.updateCastigoImporte(castigo, id_pesaje);
	}

	@Override
	public Pesaje leerPorId(Integer id) {
		return pesajerRepo.findById(id).orElse(null);
	}

	@Override
	public List<Pesaje> listar() {
		return pesajerRepo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		//sectorRepo.deleteById(id);
	}

	@Override
	public List<Pesaje> listarPorEstado() {
		return pesajerRepo.leerPorEstado();
	}


}
