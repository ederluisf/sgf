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

import br.com.sgf.api.entities.Vehicle;
import br.com.sgf.api.response.ResponseWrapper;
import br.com.sgf.api.services.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*") //Mudar para o Endereço do SGF
public class VehicleController {
	
	private static final Logger log = LoggerFactory.getLogger(VehicleController.class);

	ResponseWrapper<Vehicle> response;
	
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Vehicle>> getById(@PathVariable Long id) {
		response = new ResponseWrapper<>();
		
		log.info("Searching vehicle by id {}", id);
		Optional<Vehicle> vehicle = vehicleService.getById(id);

		if(!vehicle.isPresent()) {
			log.info("Vehicle not found to id: {}", id);
			response.getErrors().add("Veículo não encontrado para o id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(vehicle.get());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseWrapper<Vehicle>> save(@RequestBody @Valid Vehicle vehicle) {
		response = new ResponseWrapper<>();
		
		log.info("Saving {} {} vehicle", vehicle.getModel().getName(), vehicle.getModel().getVersion());
		
		String modelName = vehicle.getModel().getName();
		String modelVersion = vehicle.getModel().getVersion();
		
		if (vehicleService.getByModelNameAndModelVersion(modelName, modelVersion).isPresent()) {
			response.getErrors().add("Já existe um veículo com este modelo e versão!");
			return ResponseEntity.badRequest().body(response);
		}
		
		if (vehicleService.getByPlate(vehicle.getPlate()).isPresent()) {
			response.getErrors().add("Já existe um veículo cadastrado com esta placa!");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(vehicleService.save(vehicle));
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Vehicle>> update(@PathVariable("id") Long id, 
															  @RequestBody @Valid Vehicle vehicle,
															  BindingResult result) {
		
		log.info("Updating vehicle: {}", vehicle.getModel().getName());
		response = new ResponseWrapper<>();
		
		Optional<Vehicle> savedVehicle = vehicleService.getById(id);
		
		if (!savedVehicle.isPresent()) {
			result.addError(new ObjectError("model", "Veículo não encotrado"));
		}
		else {
			if(!savedVehicle.get().getModel().getName().equals(vehicle.getModel().getName()) &&
				(vehicleService.getByModelName(vehicle.getModel().getName()).isPresent())) {
					result.addError(new ObjectError("model", "Já existe um veículo com este modelo!"));
			}
		}
		
		
		if (result.hasErrors()) {
			log.error("Erro ao tentar atualizar o veículo: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(vehicleService.save(vehicle));
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseWrapper<String>> delete(@PathVariable("id") Long id) {
		ResponseWrapper<String> resp = new ResponseWrapper<>();

		log.info("Removendo veículo de id: {}", id);
		
		Optional<Vehicle> vehicle = this.vehicleService.getById(id);
		
		if(!vehicle.isPresent()) {
			log.info("Erro ao remover veículo. Registro não encontrado para o id {}", id);
			resp.getErrors().add("Erro ao remover veículo. Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(resp);
		}
				
		vehicleService.delete(id);
		return ResponseEntity.ok(resp);
	}
}
