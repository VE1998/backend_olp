package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olpasa.model.Conductor;

public interface IConductorRepo extends JpaRepository<Conductor, Integer>{

}
