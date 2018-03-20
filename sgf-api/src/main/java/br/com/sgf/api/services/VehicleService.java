package br.com.sgf.api.services;

import java.util.List;
import java.util.Optional;

import br.com.sgf.api.entities.Vehicle;

public interface VehicleService {

	Vehicle save(Vehicle vehicle);
	void delete(Long id);
	List<Vehicle> findAll();

	Optional<Vehicle> getById(Long id);
	Optional<Vehicle> getByModelName(String name);
	Optional<Vehicle> getByModelNameAndModelVersion(String name, String version);
	Optional<Vehicle> getByPlate(String plate);
}