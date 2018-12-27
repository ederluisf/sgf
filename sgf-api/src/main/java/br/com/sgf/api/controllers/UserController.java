package br.com.sgf.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgf.api.entities.User;
import br.com.sgf.api.response.ResponseWrapper;
import br.com.sgf.api.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	ResponseWrapper<User> response;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<User>> getById(@PathVariable Long id) {
		response = new ResponseWrapper<>();
		
		log.info("Searching user by id {}", id);
		Optional<User> user = userService.getById(id);

		if(!user.isPresent()) {
			log.info("User not found to id: {}", id);
			response.getErrors().add("Usuário não encontrada para o id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(user.get());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseWrapper<User>> save(@RequestBody @Valid User user) {
		response = new ResponseWrapper<>();
		
		log.info("Saving {} user", user.getName());
		
		if (userService.getByNameIgnoreCase(user.getName()).isPresent()) {
			response.getErrors().add("Já existe um usuário com este nome!");
			return ResponseEntity.badRequest().body(response);
		}
		
		if (userService.getByEmailIgnoreCase(user.getEmail()).isPresent()) {
			response.getErrors().add("Já existe um usuário com este endereço de email!");
			return ResponseEntity.badRequest().body(response);
		}
		
		String password = user.getEmail().split("\\@")[0];
		user.setPassword(password);
		
		response.setData(userService.save(user));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseWrapper<User>> update(@PathVariable("id") Long id, 
															  @RequestBody @Valid User user,
															  BindingResult result) {
		
		log.info("Updating user: {}", user.getName());
		response = new ResponseWrapper<>();
		
		Optional<User> savedUser = userService.getById(id);
		
		if (!savedUser.isPresent()) {
			result.addError(new ObjectError("user", "Montadora não encotrada"));
		}
		else {
			if(!savedUser.get().getName().equals(user.getName()) &&
				(userService.getByNameIgnoreCase(user.getName()).isPresent())) {
					result.addError(new ObjectError("manufacturer", "Já existe um usuário com este nome!"));
			}
			
			if(!savedUser.get().getEmail().equals(user.getEmail()) &&
					(userService.getByEmailIgnoreCase(user.getEmail()).isPresent())) {
						result.addError(new ObjectError("user", "Já existe um usuário com este endereço de email!"));
				}
		}
		
		
		if (result.hasErrors()) {
			log.error("Erro ao tentar atualizar o usuário: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(userService.save(user));
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseWrapper<String>> delete(@PathVariable("id") Long id) {
		ResponseWrapper<String> resp = new ResponseWrapper<>();

		log.info("Removendo usuário de id: {}", id);
		
		Optional<User> user = this.userService.getById(id);
		
		if (!user.isPresent()) {
			log.info("Erro ao remover usuário. Registro não encontrado para o id {}", id);
			resp.getErrors().add("Erro ao remover usuário. Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(resp);
		}
				
		userService.delete(id);
		return ResponseEntity.ok(resp);
	}
}
