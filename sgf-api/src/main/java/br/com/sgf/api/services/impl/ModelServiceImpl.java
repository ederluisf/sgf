package br.com.sgf.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgf.api.entities.Model;
import br.com.sgf.api.repositories.ModelRepository;
import br.com.sgf.api.services.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	private static final Logger log = LoggerFactory.getLogger(ModelServiceImpl.class);
	
	@Autowired
	ModelRepository repository;
	
	@Override
	public Optional<Model> getById(Long id) {
		log.info("Searching entity by id {}", id);
		return repository.findById(id);
	}

	@Override
	public Model save(Model model) {
		log.info("Saving model {}", model.getName());
		return repository.save(model);
	}

	@Override
	public void delete(Long id) {
		log.info("Removing model id: {}", id);
		repository.deleteById(id);
	}
	
	@Override
	public List<Model> findAll() {
		log.info("Searching all models");
		return repository.findAll();
	}
	
	@Override
	public Optional<Model> getByName(String name) {
		return repository.getByName(name);
	}
}
