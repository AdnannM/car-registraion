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

import com.api.dto.RegistrovanoNaOsobuDto;

import com.api.service.RegistrovanoNaOsobuService;

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
})
public class RegistrovanoNaOsobuController {

	@Autowired
	RegistrovanoNaOsobuService registrovanoNaOsobuService;
	
	@GetMapping("/registrovano")
	public ResponseEntity<List<RegistrovanoNaOsobuDto>> sveRegistrovaneOsobe() {
		List<RegistrovanoNaOsobuDto> regNaOsobu = registrovanoNaOsobuService.sveRegistrovaneOsobe();
		return new ResponseEntity<>(regNaOsobu, HttpStatus.OK);
	}
	
	@PostMapping("/registrovano/add")
	public ResponseEntity<RegistrovanoNaOsobuDto> addRegistrovaneOsobe(@RequestBody RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		RegistrovanoNaOsobuDto novaRegOsoba = registrovanoNaOsobuService.createRegistrovanuOsobu(registrovanoNaOsobu);
		return new ResponseEntity<RegistrovanoNaOsobuDto>(novaRegOsoba, HttpStatus.CREATED);
	}
	
	@PutMapping("/registrovano/update{id}")
	public ResponseEntity<RegistrovanoNaOsobuDto> updateRegistrovaneOsobe(@PathVariable Integer id, @RequestBody  RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		RegistrovanoNaOsobuDto ispraviRegistrovanuOsobu = registrovanoNaOsobuService.updateRegistrovanuOsobu(id,registrovanoNaOsobu);
		return new ResponseEntity<RegistrovanoNaOsobuDto>(ispraviRegistrovanuOsobu, HttpStatus.OK);
	}
	
	@DeleteMapping("/registrovano/delete{id}")
	public ResponseEntity<?>deleteRegistrovanuOsobu(@PathVariable("id") Integer id) {
		registrovanoNaOsobuService.deleteRegistrovanuOsobu(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
