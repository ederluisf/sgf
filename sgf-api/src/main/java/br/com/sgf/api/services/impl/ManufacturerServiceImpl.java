package br.com.sgf.api.services.impl;

import java.util.List;

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
	public List<Manufacturer> findAll() {
		log.info("Searching all manufacturers");
		return repository.findAll();
	}
}
