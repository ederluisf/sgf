package br.com.sgf.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgf.api.entities.Model;

@Transactional
public interface ModelRepository extends JpaRepository<Model, Long> {

	Optional<Model> getByName(String name);
}