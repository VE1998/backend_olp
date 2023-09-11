package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.CuentaBancaria;

public interface ICuentaBancariaRepo extends JpaRepository<CuentaBancaria, Integer>{

}
