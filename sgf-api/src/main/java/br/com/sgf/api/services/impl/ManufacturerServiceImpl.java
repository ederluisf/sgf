package br.com.sgf.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgf.api.entities.Manufacturer;
import br.com.sgf.api.repositories.ManufacturerRepository;
import br.com.sgf.api.services.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private static final Logger log = LoggerFactory.getLogger(ManufacturerServiceImpl.class);
	
	@Autowired
	ManufacturerRepository repository;
	
	@Override
	public Optional<Manufacturer> getById(Long id) {
		log.info("Searching manufacturer by id {}", id);
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		log.info("Saving manufacturer {}", manufacturer.getName());
		return repository.save(manufacturer);
	}
}
