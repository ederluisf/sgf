package br.com.sgf.api.services;

import java.util.Optional;

import br.com.sgf.api.entities.Manufacturer;

public interface ManufacturerService {

	Optional<Manufacturer> getById(Long id);
	Manufacturer save(Manufacturer manufacturer);
}