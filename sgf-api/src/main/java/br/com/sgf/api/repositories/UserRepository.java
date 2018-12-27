package br.com.sgf.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgf.api.entities.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> getByNameIgnoreCase(String name);
	Optional<User> getByEmailIgnoreCase(String email);
}