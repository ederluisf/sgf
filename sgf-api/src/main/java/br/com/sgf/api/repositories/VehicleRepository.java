package br.com.sgf.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgf.api.entities.Vehicle;

@Transactional
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	Optional<Vehicle> getByModelName(String name);
	Optional<Vehicle> getByModelNameAndModelVersion(String name, String version);
	Optional<Vehicle> getByPlate(String plate);
}