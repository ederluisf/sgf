package br.com.sgf.api.services;

import java.util.List;
import java.util.Optional;

import br.com.sgf.api.entities.Model;

public interface ModelService {

	Model save(Model model);
	void delete(Long id);
	List<Model> findAll();

	Optional<Model> getById(Long id);
	Optional<Model> getByName(String name);
}