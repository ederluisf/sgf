package br.com.sgf.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgf.api.entities.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
}