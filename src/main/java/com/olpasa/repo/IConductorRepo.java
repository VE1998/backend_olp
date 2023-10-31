package com.olpasa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.olpasa.model.Conductor;


public interface IConductorRepo extends JpaRepository<Conductor, Integer>{
	
	@Query(value = "SELECT * FROM conductor c WHERE c.estado=:estado", nativeQuery = true)
	List<Conductor> buscarPorEstado(@Param("estado") String estado);

}
