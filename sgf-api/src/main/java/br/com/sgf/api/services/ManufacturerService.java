package br.com.sgf.api.services;

import java.util.List;
import java.util.Optional;

import br.com.sgf.api.entities.Manufacturer;

public interface ManufacturerService {

	Manufacturer save(Manufacturer manufacturer);
	void delete(Long id);
	List<Manufacturer> findAll();

	Optional<Manufacturer> getById(Long id);
	Optional<Manufacturer> getByNameIgnoreCase(String name);
}