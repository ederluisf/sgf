package br.com.sgf.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgf.api.entities.Vehicle;
import br.com.sgf.api.repositories.VehicleRepository;
import br.com.sgf.api.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	VehicleRepository repository;
	
	@Override
	public Optional<Vehicle> getById(Long id) {
		log.info("Searching entity by id {}", id);
		return repository.findById(id);
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		log.info("Saving vehicle {}, plate {}", vehicle.getModel().getName(), vehicle.getPlate());
		return repository.save(vehicle);
	}

	@Override
	public void delete(Long id) {
		log.info("Removing vehicle id: {}", id);
		repository.deleteById(id);
	}
	
	@Override
	public List<Vehicle> findAll() {
		log.info("Searching all {}", "vehicles");
		return repository.findAll();
	}
	
	@Override
	public Optional<Vehicle> getByModelName(String name) {
		return repository.getByModelName(name);
	}

	@Override
	public Optional<Vehicle> getByModelNameAndModelVersion(String name, String version) {
		return repository.getByModelNameAndModelVersion(name, version);
	}
	
	@Override
	public Optional<Vehicle> getByPlate(String plate) {
		return repository.getByPlate(plate);
	}
}
