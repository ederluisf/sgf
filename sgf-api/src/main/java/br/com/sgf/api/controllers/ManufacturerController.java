package br.com.sgf.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgf.api.entities.Manufacturer;
import br.com.sgf.api.response.ResponseWrapper;
import br.com.sgf.api.services.ManufacturerService;

@RestController
@RequestMapping("/manufacturers")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class ManufacturerController {
	
	private static final Logger log = LoggerFactory.getLogger(ManufacturerController.class);

	ResponseWrapper<Manufacturer> response;
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping
	public List<Manufacturer> findAll() {
		return manufacturerService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Manufacturer>> getById(@PathVariable Long id) {
		response = new ResponseWrapper<>();
		
		log.info("Searching manufacturer by id {}", id);
		Optional<Manufacturer> manufacturer = manufacturerService.getById(id);

		if(!manufacturer.isPresent()) {
			log.info("Manufacturer not found to id: " + id);
			response.getErrors().add("Empresa não encontrada para o id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(manufacturer.get());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseWrapper<Manufacturer>> save(@RequestBody @Valid Manufacturer manufacturer) {
		response = new ResponseWrapper<>();
		
		log.info("Saving {} manufacturer", manufacturer.getName());
		
		if (manufacturerService.getByName(manufacturer.getName()).isPresent()) {
			response.getErrors().add("Já existe uma montadora com este nome!");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(manufacturerService.save(manufacturer));
		return ResponseEntity.ok(response);
	}
}