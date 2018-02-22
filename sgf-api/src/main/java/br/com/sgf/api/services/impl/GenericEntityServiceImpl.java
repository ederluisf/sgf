package br.com.sgf.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgf.api.entities.GenericEntity;
import br.com.sgf.api.repositories.GenericEntityRepository;
import br.com.sgf.api.services.GenericEntityService;

@Service
public class GenericEntityServiceImpl implements GenericEntityService {

	private static final Logger log = LoggerFactory.getLogger(GenericEntityServiceImpl.class);
	
	@Autowired
	GenericEntityRepository repository;
	
	@Override
	public Optional<GenericEntity> getById(Long id) {
		log.info("Searching entity by id {}", id);
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public GenericEntity save(GenericEntity entity) {
		log.info("Saving entity {}", entity.getId() + " - " + entity.getClass().getName());
		return repository.save(entity);
	}

	@Override
	public void delete(GenericEntity entity) {
		log.info("Removing entity {}", entity.getId() + " - " + entity.getClass().getName());
		repository.delete(entity);
	}
}
