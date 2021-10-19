package com.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.api.dao.ModelVozilaDao;
import com.api.dao.RegistrovanoNaOsobuDao;


import com.api.dto.VoziloDto;



public interface VoziloService {

	/*
	 * - GET, PUT, POST, DELETE
	 */
	List<VoziloDto> sveVozila();
	VoziloDto createVozilo(VoziloDto vozilo);
	VoziloDto updateVozilo(Integer id, VoziloDto vozilo);
	void deleteVozilo(Integer id);

	/*
	 * - Person
	 */
	Optional<RegistrovanoNaOsobuDao> checkAge(Date datumRodjenja);
	Optional<RegistrovanoNaOsobuDao> findByIme(String ime);
	Optional<RegistrovanoNaOsobuDao> findByPrezime(String prezime);
	Optional<RegistrovanoNaOsobuDao> findByJmbg(long jmbg);
	
	/*
	 * - Car
	 */
	Optional<ModelVozilaDao> findByModel(String model);
	Optional<ModelVozilaDao> findByProizvodjac(String proizvodjac);
}
