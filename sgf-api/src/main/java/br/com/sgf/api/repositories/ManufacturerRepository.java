package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgf.api.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}