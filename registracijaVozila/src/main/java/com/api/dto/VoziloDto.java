package com.api.dto;



public class VoziloDto {

	private Integer id;
	private String registracijskaOznaka;
	
	RegistrovanoNaOsobuDto registrovanoNaOsobuDto;
	
	
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
