package com.olpasa.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.olpasa.model.Pesaje;

import jakarta.transaction.Transactional;

public interface IPesajeRepo extends JpaRepository<Pesaje, Integer>{
	
	
	@Query(value = "SELECT * FROM pesaje WHERE estado=:estado", nativeQuery = true)
	List<Pesaje> leerPorEstado(@Param("estado") String estado);
	
	
}
