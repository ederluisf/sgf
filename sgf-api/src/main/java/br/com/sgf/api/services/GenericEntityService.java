package br.com.sgf.api.services;

import java.util.Optional;

import br.com.sgf.api.entities.GenericEntity;

public interface GenericEntityService {

	Optional<GenericEntity> getById(Long id);
	GenericEntity save(GenericEntity genericEntity);
	void delete(GenericEntity entity);
}