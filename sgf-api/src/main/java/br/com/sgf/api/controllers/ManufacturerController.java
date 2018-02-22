package br.com.sgf.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgf.api.entities.GenericEntity;
import br.com.sgf.api.entities.Manufacturer;
import br.com.sgf.api.services.GenericEntityService;
import br.com.sgf.api.services.ManufacturerService;

@RestController
@RequestMapping("/manufacturers")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class ManufacturerController {
	
	private static final Logger log = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	GenericEntityService entityService;
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping
	public List<Manufacturer> findAll() {
		return manufacturerService.findAll();
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Manufacturer> getById(@PathVariable Long id) {
		
		log.info("Searching manufacturer by id {}", id);
		
		Optional<GenericEntity> entity = entityService.getById(id);

		if(entity.isPresent()) {
			return ResponseEntity.ok((Manufacturer)entity.get());
		} 
		else {
			return ResponseEntity.notFound().build();
		}
	}
}