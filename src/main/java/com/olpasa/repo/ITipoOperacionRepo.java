package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.TipoOperacion;

public interface ITipoOperacionRepo extends JpaRepository<TipoOperacion, Integer>{

}
