package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.Parcela;

public interface IParcelaRepo extends JpaRepository<Parcela, Integer>{

}
