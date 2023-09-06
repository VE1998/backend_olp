package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.Banco;

public interface IBancoRepo extends JpaRepository<Banco, Integer>{

}
