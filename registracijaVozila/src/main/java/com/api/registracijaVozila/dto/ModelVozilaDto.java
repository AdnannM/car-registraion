package com.api.registracijaVozila.dto;

public class ModelVozilaDto {

	private Integer id;
	private String model;
	private Integer godina;
	private String proizdvodjac;
	
	
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
