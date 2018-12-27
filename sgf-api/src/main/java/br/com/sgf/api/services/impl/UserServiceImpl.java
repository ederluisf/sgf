package br.com.sgf.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgf.api.entities.User;
import br.com.sgf.api.repositories.UserRepository;
import br.com.sgf.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository repository;
	
	@Override
	public Optional<User> getById(Long id) {
		log.info("Searching entity by id {}", id);
		return repository.findById(id);
	}

	@Override
	public User save(User user) {
		log.info("Saving user {}", user.getName());
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		log.info("Removing user id: {}", id);
		repository.deleteById(id);
	}
	
	@Override
	public List<User> findAll() {
		log.info("Searching all users");
		return repository.findAll();
	}
	
	@Override
	public Optional<User> getByNameIgnoreCase(String name) {
		return repository.getByNameIgnoreCase(name);
	}

	@Override
	public Optional<User> getByEmailIgnoreCase(String email) {
		return repository.getByEmailIgnoreCase(email);
	}
}
