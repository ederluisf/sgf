package br.com.sgf.api.services;

import java.util.List;
import java.util.Optional;

import br.com.sgf.api.entities.User;

public interface UserService {

	User save(User user);
	void delete(Long id);
	List<User> findAll();

	Optional<User> getById(Long id);
	Optional<User> getByNameIgnoreCase(String name);
	Optional<User> getByEmailIgnoreCase(String email);
}