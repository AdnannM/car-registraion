package com.api.registracijaVozila.controller;

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


import com.api.registracijaVozila.dao.VoziloDao;
import com.api.registracijaVozila.dto.VoziloDto;
import com.api.registracijaVozila.response.MessageResponse;
import com.api.registracijaVozila.service.VoziloService;

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
public class VoziloController {

	@Autowired
	VoziloService voziloService;
	
	@GetMapping("/registracija/all")
	public ResponseEntity<List<VoziloDao>> svaVozila() {
		List<VoziloDao> vozilo = voziloService.sveVozila();
		return new ResponseEntity<>(vozilo, HttpStatus.OK);
	}
	
	@PostMapping("/registracija/add")
	public ResponseEntity<MessageResponse> addVozilo(@RequestBody VoziloDto vozilo) {
		MessageResponse novoVozilo = voziloService.createVozilo(vozilo);
		return new ResponseEntity<>(novoVozilo, HttpStatus.CREATED);
	}
	
	@PutMapping("/registracija/update{id}")
	public ResponseEntity<MessageResponse> updateVozilo(@PathVariable Integer id, @RequestBody VoziloDao vozilo) {
		MessageResponse ispraviVozilo = voziloService.updateVozilo(id,vozilo);
		return new ResponseEntity<>(ispraviVozilo, HttpStatus.OK);
	}
	
	@DeleteMapping("/registracija/delete{id}")
	public ResponseEntity<?>deleteVozilo(@PathVariable("id") Integer id) {
		voziloService.deleteVozilo(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
