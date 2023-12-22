package com.olpasa.repo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.olpasa.model.Pesaje;



public interface IPesajeRepo extends JpaRepository<Pesaje, Integer>{
	
	
	@Query(value = "SELECT * FROM pesaje p WHERE estado='A' AND id_to=1", nativeQuery = true)
	List<Pesaje> leerPorEstado();


	@Transactional
	@Modifying
	@Query("UPDATE Pesaje pe SET pe.castigo_planilla = :castigo_planilla WHERE pe.id_pesaje = :id_pesaje")
	int updateCastigoPlanilla(@Param("castigo_planilla") BigDecimal castigo_planilla, @Param("id_pesaje") Integer id_pesaje) throws Exception;

	@Transactional
	@Modifying
	@Query("UPDATE Pesaje pe SET pe.castigo_importe = :castigo_importe WHERE pe.id_pesaje = :id_pesaje")
	int updateCastigoImporte(@Param("castigo_importe") BigDecimal castigo_importe, @Param("id_pesaje") Integer id_pesaje) throws Exception;

	
}
