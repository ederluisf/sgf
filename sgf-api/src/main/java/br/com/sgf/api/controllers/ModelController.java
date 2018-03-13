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

import br.com.sgf.api.entities.Model;
import br.com.sgf.api.response.ResponseWrapper;
import br.com.sgf.api.services.ModelService;

@RestController
@RequestMapping("/models")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class ModelController {
	
	private static final Logger log = LoggerFactory.getLogger(ModelController.class);

	ResponseWrapper<Model> response;
	
	@Autowired
	ModelService modelService;
	
	@GetMapping
	public List<Model> findAll() {
		return modelService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Model>> getById(@PathVariable Long id) {
		response = new ResponseWrapper<>();
		
		log.info("Searching model by id {}", id);
		Optional<Model> model = modelService.getById(id);

		if(!model.isPresent()) {
			log.info("Model not found to id: {}", id);
			response.getErrors().add("Modelo não encontrado para o id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(model.get());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseWrapper<Model>> save(@RequestBody @Valid Model model) {
		response = new ResponseWrapper<>();
		
		log.info("Saving {} manufacturer", model.getName());
		
		if (modelService.getByName(model.getName()).isPresent()) {
			response.getErrors().add("Já existe uma montadora com este nome!");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(modelService.save(model));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Model>> update(@PathVariable("id") Long id, 
															  @RequestBody @Valid Model model,
															  BindingResult result) {
		
		log.info("Updating manufacturer: {}", model.getName());
		response = new ResponseWrapper<>();
		
		Optional<Model> savedModel = modelService.getById(id);
		
		if (!savedModel.isPresent()) {
			result.addError(new ObjectError("model", "Modelo não encotrado"));
		}
		else {
			if(!savedModel.get().getName().equals(model.getName()) &&
				(modelService.getByName(model.getName()).isPresent())) {
					result.addError(new ObjectError("model", "Já existe um modelo com este nome!"));
			}
		}
		
		
		if (result.hasErrors()) {
			log.error("Erro ao tentar atualizar o modelo: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(modelService.save(model));
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseWrapper<String>> delete(@PathVariable("id") Long id) {
		ResponseWrapper<String> resp = new ResponseWrapper<>();

		log.info("Removendo modelo de id: {}", id);
		
		Optional<Model> model = this.modelService.getById(id);
		
		if(!model.isPresent()) {
			log.info("Erro ao remover modelo. Registro não encontrado para o id {}", id);
			resp.getErrors().add("Erro ao remover modelo. Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(resp);
		}
				
		modelService.delete(id);
		return ResponseEntity.ok(resp);
	}
}
