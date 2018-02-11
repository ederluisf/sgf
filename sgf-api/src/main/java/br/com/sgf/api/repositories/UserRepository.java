package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgf.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}