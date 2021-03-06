package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.dto.ModelVozilaDto;

import com.api.service.ModelVozilaService;

import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/api")

@ApiResponses(value = {
		
		@io.swagger.annotations.ApiResponse(code = 400,
											message = "This is a bad request, please follow the API documentation for the proper request format"),
		@io.swagger.annotations.ApiResponse(code = 401,
											message = "Doe to security your access request cannot be authorized"),
		@io.swagger.annotations.ApiResponse(code = 500,
											message = "The server is down.")	
	}	
)
public class ModelVozilaController {

	
	@Autowired
	ModelVozilaService modelVozilaService;
	
	@GetMapping("/model/vozila")
	public ResponseEntity<List<ModelVozilaDto>> sviModeliVozila() {
		List<ModelVozilaDto> modelVozila = modelVozilaService.sviModeliVozila();
		return new ResponseEntity<>(modelVozila, HttpStatus.OK);
	}
	
	@PostMapping("/model/vozila/add")
	public ResponseEntity<ModelVozilaDto> addNoviModelVozila(@RequestBody ModelVozilaDto modelVozila) {
		ModelVozilaDto noviModelVozila = modelVozilaService.createModelVozila(modelVozila);
		return new ResponseEntity<ModelVozilaDto>(noviModelVozila, HttpStatus.CREATED);
	}
	
	@PutMapping("/model/vozila/update{id}")
	public ResponseEntity<ModelVozilaDto> updateModelVozila(@PathVariable Integer id, @RequestBody ModelVozilaDto vozilo) {
		ModelVozilaDto ispraviModelVozila = modelVozilaService.updateModelVozila(id,vozilo);
		return new ResponseEntity<ModelVozilaDto>(ispraviModelVozila, HttpStatus.OK);
	}
	
	@DeleteMapping("/model/vozila/delete{id}")
	public ResponseEntity<?>deleteModelVozila(@PathVariable("id") Integer id) {
		modelVozilaService.deleteModelVozila(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
