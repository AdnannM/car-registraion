package com.api.dto;

import java.util.List;

public class VoziloDto {

	private Integer id;
	private String registracijskaOznaka;
	
	RegistrovanoNaOsobuDto registrovanoNaOsobuDto;
	
	ModelVozilaDto modelVozilaDto;
	
	KarakteristikeVozilaDto karakteristikeVozila;
	
	RegistracijaDto registracija;
	
	
	public void setRegistracija(RegistracijaDto registracija) {
		this.registracija = registracija;
	}
	
	public RegistracijaDto getRegistracija() {
		return registracija;
	}
	
	public void setKarakteristikeVozila(KarakteristikeVozilaDto karakteristikeVozila) {
		this.karakteristikeVozila = karakteristikeVozila;
	}
	public KarakteristikeVozilaDto getKarakteristikeVozila() {
		return karakteristikeVozila;
	}
	
	public  ModelVozilaDto getModelVozilaDto() {
		return modelVozilaDto;
	}
	public void setModelVozilaDto( ModelVozilaDto modelVozilaResultList) {
		this.modelVozilaDto = modelVozilaResultList;
	}
	public RegistrovanoNaOsobuDto getRegistrovanoNaOsobuDto() {
		return registrovanoNaOsobuDto;
	}
	public void setRegistrovanoNaOsobuDto(RegistrovanoNaOsobuDto registovanoNaOsobuDto) {
		this.registrovanoNaOsobuDto = registovanoNaOsobuDto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegistracijskaOznaka() {
		return registracijskaOznaka;
	}
	public void setRegistracijskaOznaka(String registracijskaOznaka) {
		this.registracijskaOznaka = registracijskaOznaka;
	}
}
