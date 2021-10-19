package com.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.api.dao.ModelVozilaDao;
import com.api.dao.RegistracijaDao;
import com.api.dao.RegistrovanoNaOsobuDao;


import com.api.dto.VoziloDto;



public interface VoziloService {

	/*
	 * - GET, PUT, POST, DELETE
	 */
	List<VoziloDto> sveVozila();
	List<VoziloDto> createVozilo(VoziloDto vozilo);
	List<VoziloDto> updateVozilo(Integer id, VoziloDto vozilo);
	void deleteVozilo(Integer id);

	/*
	 * - Person
	 */
	Optional<RegistrovanoNaOsobuDao> checkAge(Date datumRodjenja);
	Optional<RegistrovanoNaOsobuDao> findByIme(String ime);
	Optional<RegistrovanoNaOsobuDao> findByPrezime(String prezime);
	Optional<RegistrovanoNaOsobuDao> findByJmbg(long jmbg);
	List<RegistrovanoNaOsobuDao> findByRegistrovanoAll();
	
	/*
	 * - Car
	 */
	Optional<ModelVozilaDao> findByModel(String model);
	Optional<ModelVozilaDao> findByproizdvodjac(String proizdvodjac);
	List<ModelVozilaDao> findByModelAll();
	
	/*
	 * - Registration
	 */
	Optional<RegistracijaDao> findByRegistration(boolean isteklaRegistracija);
}
