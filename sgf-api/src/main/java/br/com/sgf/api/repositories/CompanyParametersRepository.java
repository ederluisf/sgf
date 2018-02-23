package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgf.api.entities.CompanyParameters;

@Transactional
public interface CompanyParametersRepository extends JpaRepository<CompanyParameters, Long> {
	
}