package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgf.api.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
}