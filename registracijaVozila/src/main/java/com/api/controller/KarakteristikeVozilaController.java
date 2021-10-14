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

import com.api.dto.KarakteristikeVozilaDto;
import com.api.service.KarakteristikeVozilaService;

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
public class KarakteristikeVozilaController {
	
	@Autowired
	KarakteristikeVozilaService karakteristikeVozilaService;
	
	@GetMapping("/karakteristike/vozila")
	public ResponseEntity<List<KarakteristikeVozilaDto>> sveKarakteristikeVozila() {
		List<KarakteristikeVozilaDto> karakteristikaVozila = karakteristikeVozilaService.sveKarakteristikeVozila();
		return new ResponseEntity<>(karakteristikaVozila, HttpStatus.OK);
	}
	
	@PostMapping("/karakteristike/vozila/add")
	public ResponseEntity<KarakteristikeVozilaDto> addNoviModelVozila(@RequestBody KarakteristikeVozilaDto karakteristikeVozila) {
		KarakteristikeVozilaDto noveKarakteristikeVozila = karakteristikeVozilaService.createKarakteristikeVozila(karakteristikeVozila);
		return new ResponseEntity<KarakteristikeVozilaDto>(noveKarakteristikeVozila, HttpStatus.CREATED);
	}
	
	@PutMapping("/karakteristike/vozila/update{id}")
	public ResponseEntity<KarakteristikeVozilaDto> updateModelVozila(@PathVariable Integer id, @RequestBody KarakteristikeVozilaDto karakteristikeVozila) {
		KarakteristikeVozilaDto ispraviKarakteristikeVozila = karakteristikeVozilaService.updateKarakteristikeVozila(id,karakteristikeVozila);
		return new ResponseEntity<KarakteristikeVozilaDto>(ispraviKarakteristikeVozila, HttpStatus.OK);
	}
	
	@DeleteMapping("/mode/vozila/delete{id}")
	public ResponseEntity<?>deleteKarakteristikeVozila(@PathVariable("id") Integer id) {
		karakteristikeVozilaService.deleteKarakteristikeVozila(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
