package br.com.sgf.api.services;

import java.util.List;

import br.com.sgf.api.entities.Manufacturer;

public interface ManufacturerService {

	List<Manufacturer> findAll();
}