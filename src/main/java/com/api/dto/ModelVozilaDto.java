package com.api.dto;

public class ModelVozilaDto {

	private Integer id;
	private String model;
	private Integer godina;
	private String proizdvodjac;
	
	KarakteristikeVozilaDto karakteristikeVozilaDto;
	
	public KarakteristikeVozilaDto getKarakteristikeVozilaDto() {
		return karakteristikeVozilaDto;
	}
	public void setKarakteristikeVozilaDto(KarakteristikeVozilaDto karakteristikeVozilaDto) {
		this.karakteristikeVozilaDto = karakteristikeVozilaDto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getGodina() {
		return godina;
	}
	public void setGodina(Integer godina) {
		this.godina = godina;
	}
	public String getProizdvodjac() {
		return proizdvodjac;
	}
	public void setProizdvodjac(String proizdvodjac) {
		this.proizdvodjac = proizdvodjac;
	}
}
