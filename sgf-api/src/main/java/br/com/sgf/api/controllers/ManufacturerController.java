package br.com.sgf.api.controllers;

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

import br.com.sgf.api.entities.Manufacturer;
import br.com.sgf.api.services.ManufacturerService;

@RestController
@RequestMapping("/manufacturers")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class ManufacturerController {
	
	private static final Logger log = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping("{/id}")
	public ResponseEntity<Manufacturer> getById(@PathVariable Long id) {
		
		log.info("Searching manufacturer by id {}", id);
		Optional<Manufacturer> manufacturer = manufacturerService.getById(id);
		
		if(!manufacturer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(manufacturer.get());
	}
}