package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgf.api.entities.CompanyParameters;

public interface CompanyParametersRepository extends JpaRepository<CompanyParameters, Long> {
	
}